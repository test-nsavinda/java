package com.ecommerce.ProductService.controller;


import com.ecommerce.ProductService.dto.ProductRequest;
import com.ecommerce.ProductService.model.Product;
import com.ecommerce.ProductService.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Iterable<Product> getAllProducts(){
        return productService.getAllProducts();
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String createProduct(@RequestBody ProductRequest productRequest){
        productService.createProduct(productRequest);

        return "Product created";

    }



    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
        return "Product deleted";
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String updateProduct(@PathVariable Long id, @RequestBody ProductRequest productRequest){
        productService.updateProduct(id, productRequest);
        return "Product updated";
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Product getProductById(@PathVariable Long id){
        return productService.getProductById(id);
    }


}
