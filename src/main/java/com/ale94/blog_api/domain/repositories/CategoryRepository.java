package com.ale94.blog_api.domain.repositories;

import com.ale94.blog_api.domain.entities.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {

}
