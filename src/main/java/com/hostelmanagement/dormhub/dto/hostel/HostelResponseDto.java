package com.hostelmanagement.dormhub.dto.hostel;

import com.hostelmanagement.dormhub.dto.amenity.AmenityResponseDto;
import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Builder
@Data
public class HostelResponseDto {
    private String name;
    private String address;
    private String phone;
    private Integer singleSharingAvailable;
    private Integer doubleSharingAvailable;
    private Integer tripleSharingAvailable;
    private String cityName;
    private Set<AmenityResponseDto> amenities;
}
