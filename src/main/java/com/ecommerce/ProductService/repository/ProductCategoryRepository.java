package com.ecommerce.ProductService.repository;

import com.ecommerce.ProductService.model.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {
}
