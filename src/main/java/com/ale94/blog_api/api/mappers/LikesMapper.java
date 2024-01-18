package com.ale94.blog_api.api.mappers;

import com.ale94.blog_api.api.models.responses.LikesResponse;
import com.ale94.blog_api.domain.entities.LikesEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class LikesMapper {

    public LikesResponse entityToResponse(LikesEntity entity) {
        var response = new LikesResponse();
        BeanUtils.copyProperties(entity, response);
        return response;
    }

}
