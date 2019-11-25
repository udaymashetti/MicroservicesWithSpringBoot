package com.example.productMs.repostory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.example.productMs.entity.ProductEntity;

@Repository

public interface ProductRepostory extends JpaRepository<ProductEntity, Integer> {

}
