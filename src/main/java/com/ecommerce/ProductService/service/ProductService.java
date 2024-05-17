package com.ecommerce.ProductService.service;


import com.ecommerce.ProductService.dto.ProductRequest;
import com.ecommerce.ProductService.model.Product;
import com.ecommerce.ProductService.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductService {


    private final ProductRepository productRepository;

//    public ProductService(ProductRepository productRepository){
//        this.productRepository = productRepository;
//
//    }

    public void  createProduct(ProductRequest productRequest) {
        Product product = Product.builder()
                .productNo(UUID.randomUUID().toString())
                .productName(productRequest.getProductName())
                .productDescription(productRequest.getProductDescription())
                .productPrice(productRequest.getProductPrice())
                .productQuantity(productRequest.getProductQuantity())
//                .productCategory(
                .build();


        productRepository.save(product);

    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    public void updateProduct(Long id, ProductRequest productRequest) {
        Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        product.setProductName(productRequest.getProductName());
        product.setProductDescription(productRequest.getProductDescription());
        product.setProductPrice(productRequest.getProductPrice());
        product.setProductQuantity(productRequest.getProductQuantity());
        productRepository.save(product);
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
    }

    public Iterable<Product> getAllProducts() {
        return productRepository.findAll();
    }


}
