package com.ecommerce.ProductService.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "t_product_category")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class ProductCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;

}
