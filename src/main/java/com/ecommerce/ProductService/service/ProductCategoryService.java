package com.ecommerce.ProductService.service;


import com.ecommerce.ProductService.dto.ProductCategoryRequest;
import com.ecommerce.ProductService.model.ProductCategory;
import com.ecommerce.ProductService.repository.ProductCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductCategoryService {

    private final ProductCategoryRepository productCategoryRepository;

    public void  createProductCategory(ProductCategoryRequest productCategoryRequest) {
        ProductCategory productCategory = ProductCategory.builder()
                .name(productCategoryRequest.getName())
                .description(productCategoryRequest.getDescription())
                .build();
        productCategoryRepository.save(productCategory);
    }

    public void getProductCategories() {
        productCategoryRepository.findAll();
    }

    public void getProductCategory(Long id) {
        productCategoryRepository.deleteById(id);
    }


}
