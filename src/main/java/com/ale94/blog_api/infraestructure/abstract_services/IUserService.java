package com.ale94.blog_api.infraestructure.abstract_services;

import com.ale94.blog_api.api.models.requests.UserRequest;
import com.ale94.blog_api.api.models.responses.UserResponse;

public interface IUserService {

    UserResponse create(UserRequest request);

    UserResponse read(Long id);

    UserResponse update(UserRequest request, Long id);

    void delete(Long id);
}
