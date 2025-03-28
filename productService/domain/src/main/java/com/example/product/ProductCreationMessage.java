package com.example.product;

public class ProductCreationMessage {

    private String productId;
    private Integer quantity;

    public ProductCreationMessage(String productId, Integer quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public static ProductMessageBuilder builder() {
        return new ProductMessageBuilder();
    }

    public static class ProductMessageBuilder {
        private String productId;
        private Integer quantity;

        public ProductMessageBuilder productId(String productId) {
            this.productId = productId;
            return this;
        }

        public ProductMessageBuilder quantity(Integer quantity) {
            this.quantity = quantity;
            return this;
        }

        public ProductCreationMessage build() {
            return new ProductCreationMessage(productId, quantity);
        }
    }
}
