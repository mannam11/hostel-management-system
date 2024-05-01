package com.hostelmanagement.dormhub.dto.hostel;

import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class HostelRequestDto {

    private String name;
    private String address;
    private String phone;
    private Integer singleSharingAvailable;
    private Integer doubleSharingAvailable;
    private Integer tripleSharingAvailable;
    private Long cityId;
    private Set<Long> amenityIds;

}
