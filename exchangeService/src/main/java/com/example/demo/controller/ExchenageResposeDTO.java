package com.example.demo.controller;

import java.math.BigDecimal;
import java.math.RoundingMode;

public record ExchenageResposeDTO(

        BigDecimal value

) {

    public ExchenageResposeDTO(BigDecimal value) {
        this.value = value != null ? value.setScale(2, RoundingMode.HALF_EVEN) : null;
    }


}
