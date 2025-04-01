package com.example.schedule.ports;

import reactor.core.publisher.Mono;

public interface ScheduleServicePort {

    Mono<Void> updateExchangeRateCache();
}
