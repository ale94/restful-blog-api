package com.ale94.blog_api.domain.repositories;

import com.ale94.blog_api.domain.entities.RatingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatingRepository extends JpaRepository<RatingEntity, Long> {

}
