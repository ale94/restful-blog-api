package com.ale94.blog_api.infraestructure.services;

import com.ale94.blog_api.api.exceptions.ResourceNotFoundException;
import com.ale94.blog_api.api.mappers.CommentMapper;
import com.ale94.blog_api.api.mappers.PostMapper;
import com.ale94.blog_api.api.mappers.UserMapper;
import com.ale94.blog_api.api.models.requests.UserRequest;
import com.ale94.blog_api.api.models.responses.CommentResponse;
import com.ale94.blog_api.api.models.responses.PostResponse;
import com.ale94.blog_api.api.models.responses.UserResponse;
import com.ale94.blog_api.domain.entities.UserEntity;
import com.ale94.blog_api.domain.repositories.UserRepository;
import com.ale94.blog_api.infraestructure.abstract_services.IUserService;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@RequiredArgsConstructor
@Slf4j
@Service
public class UserServiceImpl implements IUserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PostMapper postMapper;
    private final CommentMapper commentMapper;

    @Override
    public UserResponse create(UserRequest request) {
        var userToPersist = UserEntity
            .builder()
            .firstName(request.getFirstName())
            .lastName(request.getLastName())
            .registeredAt(LocalDateTime.now())
            .email(request.getEmail())
            .mobile(request.getMobile())
            .urlProfile(request.getUrlProfile())
            .username(request.getUsername())
            .password(request.getPassword())
            .build();
        var userToPersisted = userRepository.save(userToPersist);
        log.info("User saved with id: {}", userToPersisted.getId());
        return userMapper.entityToResponse(userToPersisted);
    }

    @Override
    public UserResponse read(Long id) {
        var userFromDB = userRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("users", "id", id));
        return userMapper.entityToResponse(userFromDB);
    }

    @Override
    public UserResponse update(UserRequest request, Long id) {
        var userToUpdate = userRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("users", "id", id));
        userToUpdate.setFirstName(request.getFirstName());
        userToUpdate.setLastName(request.getLastName());
        userToUpdate.setEmail(request.getEmail());
        userToUpdate.setMobile(request.getMobile());
        userToUpdate.setUrlProfile(request.getUrlProfile());
        var userToUpdated = userRepository.save(userToUpdate);
        log.info("User updated with id: {}", userToUpdated.getId());
        return userMapper.entityToResponse(userToUpdated);
    }

    @Override
    public void delete(Long id) {
        var userToDelete = userRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("users", "id", id));
        userRepository.delete(userToDelete);
    }

    @Override
    public List<PostResponse> findPostsByUserId(Long id) {
        var user = userRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("posts", "id", id));
        return user.getPosts().stream()
            .map(postMapper::entityToResponse)
            .collect(Collectors.toList());
    }

    @Override
    public List<PostResponse> findPostsByUsername(String username) {
        var user = userRepository.findByUsername(username)
            .orElseThrow(() -> new ResourceNotFoundException("posts", "username", username));
        return user.getPosts().stream()
            .map(postMapper::entityToResponse)
            .collect(Collectors.toList());
    }

    @Override
    public List<CommentResponse> findCommentsByUserId(Long id) {
        var user = userRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("comments", "id", id));
        return user.getComments().stream()
            .map(commentMapper::entityToResponse)
            .collect(Collectors.toList());
    }

    @Override
    public List<CommentResponse> findCommentsByUsername(String username) {
        var user = userRepository.findByUsername(username)
            .orElseThrow(() -> new ResourceNotFoundException("comments", "username", username));
        return user.getComments().stream()
            .map(commentMapper::entityToResponse)
            .collect(Collectors.toList());
    }

}
