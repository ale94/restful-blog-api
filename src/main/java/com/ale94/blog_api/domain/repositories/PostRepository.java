package com.ale94.blog_api.domain.repositories;

import com.ale94.blog_api.domain.entities.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<PostEntity, Long> {

}
