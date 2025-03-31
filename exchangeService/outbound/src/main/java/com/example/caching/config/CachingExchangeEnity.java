package com.example.caching.config;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
public class CachingExchangeEnity {

    private BigDecimal value;
    private LocalDateTime cachingMoment;

}
