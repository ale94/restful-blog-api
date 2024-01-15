package com.ale94.blog_api.domain.repositories;

import com.ale94.blog_api.domain.entities.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<CommentEntity, Long> {

}
