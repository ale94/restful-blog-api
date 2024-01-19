package com.ale94.blog_api.infraestructure.abstract_services;

import com.ale94.blog_api.api.models.requests.UserRequest;
import com.ale94.blog_api.api.models.responses.CommentResponse;
import com.ale94.blog_api.api.models.responses.PostResponse;
import com.ale94.blog_api.api.models.responses.UserResponse;
import java.util.List;

public interface IUserService extends CrudService<UserResponse, UserRequest, Long> {

    List<PostResponse> findPostsByUserId(Long id);

    List<PostResponse> findPostsByUsername(String username);

    List<CommentResponse> findCommentsByUserId(Long id);

    List<CommentResponse> findCommentsByUsername(String username);

}
