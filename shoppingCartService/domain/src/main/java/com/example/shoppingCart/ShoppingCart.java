package com.example.shoppingCart;

import java.time.LocalDateTime;
import java.util.List;

public class ShoppingCart {

    private String userId;
    private List<String> products;
    private LocalDateTime createdAt;

    public ShoppingCart(String userId, List<String> products, LocalDateTime createdAt) {
        this.userId = userId;
        this.products = products;
        this.createdAt = createdAt;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<String> getProducts() {
        return products;
    }

    public void setProducts(List<String> products) {
        this.products = products;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public static ShoppingCartBuilder builder() {
        return new ShoppingCartBuilder();
    }

    public static class ShoppingCartBuilder {
        private String userId;
        private List<String> products;
        private LocalDateTime createdAt;

        public ShoppingCartBuilder userId(String userId) {
            this.userId = userId;
            return this;
        }

        public ShoppingCartBuilder products(List<String> products) {
            this.products = products;
            return this;
        }

        public ShoppingCartBuilder createdAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public ShoppingCart build() {
            return new ShoppingCart(userId, products, createdAt);
        }
    }
}
