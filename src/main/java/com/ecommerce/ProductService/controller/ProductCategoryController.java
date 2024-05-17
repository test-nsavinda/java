package com.ecommerce.ProductService.controller;


import com.ecommerce.ProductService.dto.ProductCategoryRequest;
import com.ecommerce.ProductService.service.ProductCategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/product-categories")
@AllArgsConstructor
public class ProductCategoryController {

    private  final ProductCategoryService productCategoryService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String createProductCategory(@RequestBody ProductCategoryRequest productCategoryRequest){
        productCategoryService.createProductCategory(productCategoryRequest);
        return "Product Category created";
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public String getProductCategories(){
        productCategoryService.getProductCategories();
        return "Product Categories retrieved";
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String getProductCategory(@PathVariable Long id){
        productCategoryService.getProductCategory(id);
        return "Product Category retrieved";
    }


}

