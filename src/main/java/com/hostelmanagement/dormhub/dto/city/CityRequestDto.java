package com.hostelmanagement.dormhub.dto.city;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CityRequestDto {

    private String name;

    private Integer pinCode;
}
