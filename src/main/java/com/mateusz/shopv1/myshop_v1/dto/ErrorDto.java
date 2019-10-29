package com.mateusz.shopv1.myshop_v1.dto;

import lombok.Data;

@Data
public class ErrorDto {
    private String message;
    private String exceptionClass;
}
