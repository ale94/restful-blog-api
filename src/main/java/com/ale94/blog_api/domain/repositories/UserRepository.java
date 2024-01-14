package com.ale94.blog_api.domain.repositories;

import com.ale94.blog_api.domain.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

}
