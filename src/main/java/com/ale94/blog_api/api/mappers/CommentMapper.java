package com.ale94.blog_api.api.mappers;

import com.ale94.blog_api.api.models.responses.CommentResponse;
import com.ale94.blog_api.api.models.responses.LikesResponse;
import com.ale94.blog_api.domain.entities.CommentEntity;
import com.ale94.blog_api.domain.entities.LikesEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class CommentMapper {

    public CommentResponse entityToResponse(CommentEntity entity) {
        var response = new CommentResponse();
        BeanUtils.copyProperties(entity, response);
        return response;
    }

}
