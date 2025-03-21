package com.example.demo.domain.product;

import java.math.BigDecimal;
import java.util.List;

public class Product {

    private String id;
    private String ownerId;
    private String name;
    private String description;
    private BigDecimal price;
    private List<String> imageUrls;

    public Product() {
    }

    public Product(String id, String ownerId, String name, String description, BigDecimal price, List<String> imageUrls) {
        this.id = id;
        this.ownerId = ownerId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.imageUrls = imageUrls;
    }

    public List<String> getImageUrls() {
        return imageUrls;
    }

    public void setImageUrls(List<String> imageUrls) {
        this.imageUrls = imageUrls;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public static class ProductBuilder {

        private String id;
        private String ownerId;
        private String name;
        private String description;
        private BigDecimal price;
        private List<String> imageUrls;

        public ProductBuilder() {
        }

        public static ProductBuilder builder() {
            return new ProductBuilder();
        }

        public ProductBuilder id(String id) {
            this.id = id;
            return this;
        }

        public ProductBuilder ownerId(String ownerId) {
            this.ownerId = ownerId;
            return this;
        }

        public ProductBuilder name(String name) {
            this.name = name;
            return this;
        }

        public ProductBuilder description(String description) {
            this.description = description;
            return this;
        }

        public ProductBuilder price(BigDecimal price) {
            this.price = price;
            return this;
        }

        public ProductBuilder imageUrls(List<String> imageUrls) {
            this.imageUrls = imageUrls;
            return this;
        }

        public Product build() {
            return new Product( id, ownerId, name, description, price, imageUrls );
        }

    }
}
