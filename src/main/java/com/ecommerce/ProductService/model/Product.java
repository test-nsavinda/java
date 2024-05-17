package com.ecommerce.ProductService.model;


import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name="t_product")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder


public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String productNo;
    private String productName;
    private String productDescription;
    private double productPrice;
    private int productQuantity;
    private String ProductImage;
//    @ManyToOne
//    @JoinColumn(name = "category_id")
//    private ProductCategory productCategory;



}
