package com.ale94.blog_api.infraestructure.services;

import com.ale94.blog_api.api.exceptions.ResourceNotFoundException;
import com.ale94.blog_api.api.mappers.CommentMapper;
import com.ale94.blog_api.api.models.requests.CommentRequest;
import com.ale94.blog_api.api.models.responses.CommentResponse;
import com.ale94.blog_api.domain.entities.CommentEntity;
import com.ale94.blog_api.domain.repositories.CommentRepository;
import com.ale94.blog_api.domain.repositories.PostRepository;
import com.ale94.blog_api.domain.repositories.UserRepository;
import com.ale94.blog_api.infraestructure.abstract_services.ICommentService;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@RequiredArgsConstructor
@Slf4j
@Service
public class CommentServiceImpl implements ICommentService {

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final CommentMapper commentMapper;

    @Override
    public CommentResponse create(CommentRequest request) {
        var user = userRepository
            .findById(Long.parseLong(request.getUser_id()))
            .orElseThrow(() -> new ResourceNotFoundException("users", "id", request.getUser_id()));
        var post = postRepository
            .findById(Long.parseLong(request.getPost_id()))
            .orElseThrow(() -> new ResourceNotFoundException("posts", "id", request.getPost_id()));
        var commentToPersist = CommentEntity.builder()
            .content(request.getContent())
            .publishedAt(LocalDateTime.now())
            .user(user)
            .post(post)
            .build();
        var commentToPersisted = commentRepository.save(commentToPersist);
        log.info("Comment saved with id: {}", commentToPersisted.getId());
        return commentMapper.entityToResponse(commentToPersisted);
    }

    @Override
    public CommentResponse read(Long id) {
        var commentFromDB = commentRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("comments", "id", id));
        return commentMapper.entityToResponse(commentFromDB);
    }

    @Override
    public CommentResponse update(CommentRequest request, Long id) {
        var commentToPersist = commentRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("comments", "id", id));
        commentToPersist.setContent(request.getContent());
        var commentToPersisted = commentRepository.save(commentToPersist);
        log.info("Comment updated with id: {}", commentToPersisted.getId());
        return commentMapper.entityToResponse(commentToPersisted);
    }

    @Override
    public void delete(Long id) {
        var commentToDelete = commentRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("comments", "id", id));
        commentRepository.delete(commentToDelete);
    }
}
