package com.example.exchange;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ExchangeValue {

    private String from;
    private String to;
    private BigDecimal value;

    public ExchangeValue(String from, String to, BigDecimal value) {
        this.from = from;
        this.to = to;
        this.value = value != null ? value.setScale( 2, RoundingMode.HALF_EVEN ) : null;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public static ExchangeBuilder builder() {
        return new ExchangeBuilder();
    }


    public static class ExchangeBuilder {

        private String from;
        private String to;
        private BigDecimal value;

        public ExchangeBuilder from(String from) {
            this.from = from;
            return this;
        }

        public ExchangeBuilder to(String to) {
            this.to = to;
            return this;
        }

        public ExchangeBuilder value(BigDecimal value) {
            this.value = value;
            return this;
        }

        public ExchangeValue build() {
            return new ExchangeValue(from, to, value);
        }
    }
}
