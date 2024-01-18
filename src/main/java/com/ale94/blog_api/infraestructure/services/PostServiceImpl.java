package com.ale94.blog_api.infraestructure.services;

import com.ale94.blog_api.api.mappers.PostMapper;
import com.ale94.blog_api.api.models.requests.PostRequest;
import com.ale94.blog_api.api.models.responses.PostResponse;
import com.ale94.blog_api.domain.entities.PostEntity;
import com.ale94.blog_api.domain.repositories.PostRepository;
import com.ale94.blog_api.domain.repositories.UserRepository;
import com.ale94.blog_api.infraestructure.abstract_services.IPostService;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@RequiredArgsConstructor
@Slf4j
@Service
public class PostServiceImpl implements IPostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final PostMapper postMapper;

    @Override
    public PostResponse create(PostRequest request) {
        var user = userRepository.findById(
            Long.parseLong(request.getUser_id())).orElseThrow();
        var postToPersist = PostEntity.builder()
            .title(request.getTitle())
            .content(request.getContent())
            .createdAt(LocalDateTime.now())
            .published(true)
            .publishedAt(LocalDateTime.now())
            .updatedAt(null)
            .user(user)
            .build();
        var postToPersisted = postRepository.save(postToPersist);
        log.info("Post saved with id: {}", postToPersisted.getId());
        return postMapper.entityToResponse(postToPersisted);
    }

    @Override
    public PostResponse read(Long id) {
        var postFromDB = postRepository.findById(id).orElseThrow();
        return postMapper.entityToResponse(postFromDB);
    }

    @Override
    public PostResponse update(PostRequest request, Long id) {
        var postToPersist = postRepository.findById(id).orElseThrow();
        postToPersist.setTitle(request.getTitle());
        postToPersist.setContent(request.getContent());
        postToPersist.setUpdatedAt(LocalDateTime.now());
        var postToPersisted = postRepository.save(postToPersist);
        log.info("Post updated with id: {}", postToPersisted.getId());
        return postMapper.entityToResponse(postToPersisted);
    }

    @Override
    public void delete(Long id) {
        var postToDelete = postRepository.findById(id).orElseThrow();
        postRepository.delete(postToDelete);
    }

}
