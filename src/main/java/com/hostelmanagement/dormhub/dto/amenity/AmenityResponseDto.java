package com.hostelmanagement.dormhub.dto.amenity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AmenityResponseDto {

    private String name;

    private String description;
}
