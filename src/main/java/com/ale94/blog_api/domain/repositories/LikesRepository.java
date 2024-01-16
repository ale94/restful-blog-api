package com.ale94.blog_api.domain.repositories;

import com.ale94.blog_api.domain.entities.LikesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikesRepository extends JpaRepository<LikesEntity, Long> {

}
