package com.ale94.blog_api.domain.repositories;

import com.ale94.blog_api.domain.entities.TagEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<TagEntity, Long> {

}
