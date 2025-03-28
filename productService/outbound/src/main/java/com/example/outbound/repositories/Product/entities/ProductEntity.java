package com.example.outbound.repositories.Product.entities;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.List;

@Document( collection = "products" )
@Builder
@Data
public class ProductEntity {

    @Id
    private String id;
    private String ownerId;
    private String name;
    private String description;
    private BigDecimal price;
    private List<String> imageUrls;
}
