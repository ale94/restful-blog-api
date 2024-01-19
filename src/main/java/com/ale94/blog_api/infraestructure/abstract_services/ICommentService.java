package com.ale94.blog_api.infraestructure.abstract_services;

import com.ale94.blog_api.api.models.requests.CommentRequest;
import com.ale94.blog_api.api.models.responses.CommentResponse;

public interface ICommentService extends CrudService<CommentResponse, CommentRequest, Long> {

}
