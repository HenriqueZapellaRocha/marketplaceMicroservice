package com.example.demo.outbound.exceptions.customExeptions;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class StoreAlreadyExistDTO {

    private final String error;


}
