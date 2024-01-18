package com.ale94.blog_api.infraestructure.abstract_services;

import com.ale94.blog_api.api.models.requests.PostRequest;
import com.ale94.blog_api.api.models.responses.PostResponse;

public interface IPostService extends CrudService<PostResponse, PostRequest, Long> {

}
