package com.hostelmanagement.dormhub.dto.city;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CityResponseDto {

    private String name;

    private Integer pinCode;
}
