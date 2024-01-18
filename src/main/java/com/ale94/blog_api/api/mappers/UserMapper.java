package com.ale94.blog_api.api.mappers;

import com.ale94.blog_api.api.models.responses.UserResponse;
import com.ale94.blog_api.domain.entities.UserEntity;
import org.springframework.beans.BeanUtils;

public class UserMapper {

    public UserResponse entityToResponse(UserEntity entity) {
        var response = new UserResponse();
        BeanUtils.copyProperties(entity, response);
        return response;
    }


}
