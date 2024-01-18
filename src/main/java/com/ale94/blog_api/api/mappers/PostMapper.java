package com.ale94.blog_api.api.mappers;

import com.ale94.blog_api.api.models.responses.PostResponse;
import com.ale94.blog_api.domain.entities.PostEntity;
import org.springframework.beans.BeanUtils;

public class PostMapper {

    public PostResponse entityToResponse(PostEntity entity) {
        var response = new PostResponse();
        BeanUtils.copyProperties(entity, response);
        return response;
    }
}
