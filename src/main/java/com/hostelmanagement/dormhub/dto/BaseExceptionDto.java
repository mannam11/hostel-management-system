package com.hostelmanagement.dormhub.dto;

import lombok.Data;
import lombok.experimental.SuperBuilder;
import org.springframework.http.HttpStatus;

@SuperBuilder
@Data
public class BaseExceptionDto {

    private String message;

    private HttpStatus status;
}
