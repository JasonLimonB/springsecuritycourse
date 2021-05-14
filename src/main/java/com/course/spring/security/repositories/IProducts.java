package com.course.spring.security.repositories;

import com.course.spring.security.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProducts extends JpaRepository<ProductEntity, Integer> {
}
