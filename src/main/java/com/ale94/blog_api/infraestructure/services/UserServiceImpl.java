package com.ale94.blog_api.infraestructure.services;

import com.ale94.blog_api.api.models.requests.UserRequest;
import com.ale94.blog_api.api.models.responses.UserResponse;
import com.ale94.blog_api.domain.entities.UserEntity;
import com.ale94.blog_api.domain.repositories.UserRepository;
import com.ale94.blog_api.infraestructure.abstract_services.IUserService;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@RequiredArgsConstructor
@Slf4j
@Service
public class UserServiceImpl implements IUserService {

    private final UserRepository userRepository;

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
        return this.entityToResponse(userToPersisted);
    }

    @Override
    public UserResponse read(Long id) {
        var userFromDB = userRepository.findById(id).orElseThrow();
        return this.entityToResponse(userFromDB);
    }

    @Override
    public UserResponse update(UserRequest request, Long id) {
        var userToUpdate = userRepository.findById(id).orElseThrow();
        userToUpdate.setFirstName(request.getFirstName());
        userToUpdate.setLastName(request.getLastName());
        userToUpdate.setEmail(request.getEmail());
        userToUpdate.setMobile(request.getMobile());
        userToUpdate.setUrlProfile(request.getUrlProfile());
        var userToUpdated = userRepository.save(userToUpdate);
        log.info("User updated with id: {}", userToUpdated.getId());
        return this.entityToResponse(userToUpdated);
    }

    @Override
    public void delete(Long id) {
        var userToDelete = userRepository.findById(id).orElseThrow();
        userRepository.delete(userToDelete);
    }

    // MAPPER
    private UserResponse entityToResponse(UserEntity entity) {
        var response = new UserResponse();
        BeanUtils.copyProperties(entity, response);
        return response;
    }
}
