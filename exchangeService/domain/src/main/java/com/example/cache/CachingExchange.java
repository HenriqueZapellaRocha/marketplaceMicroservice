package com.example.cache;


import java.time.LocalDateTime;

public class CachingExchange {

        private Double value;
        private LocalDateTime cachingMoment;
        private Integer viewsQuantity;

    public CachingExchange(Double value, LocalDateTime cachingMoment, Integer viewsQuantity) {
        this.value = value;
        this.cachingMoment = cachingMoment;
        this.viewsQuantity = viewsQuantity;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public LocalDateTime getCachingMoment() {
        return cachingMoment;
    }

    public void setCachingMoment(LocalDateTime cachingMoment) {
        this.cachingMoment = cachingMoment;
    }

    public Integer getViewsQuantity() {
        return viewsQuantity;
    }

    public void setViewsQuantity(Integer viewsQuantity) {
        this.viewsQuantity = viewsQuantity;
    }

    public static CachingExchangeBuilder builder() {
        return new CachingExchangeBuilder();
    }

    public static class CachingExchangeBuilder {
        private Double value;
        private LocalDateTime cachingMoment;
        private Integer viewsQuantity;

        public CachingExchangeBuilder setValue(Double value) {
            this.value = value;
            return this;
        }

        public CachingExchangeBuilder setCachingMoment(LocalDateTime cachingMoment) {
            this.cachingMoment = cachingMoment;
            return this;
        }

        public CachingExchangeBuilder setViewsQuantity(Integer viewsQuantity) {
            this.viewsQuantity = viewsQuantity;
            return this;
        }

        public CachingExchange build() {
            return new CachingExchange(value, cachingMoment, viewsQuantity);
        }
    }
}
