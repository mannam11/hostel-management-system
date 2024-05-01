package com.hostelmanagement.dormhub.service;

import com.hostelmanagement.dormhub.dto.amenity.AmenityRequestDto;
import com.hostelmanagement.dormhub.dto.amenity.AmenityResponseDto;
import com.hostelmanagement.dormhub.exception.AmenityNameMissingException;
import com.hostelmanagement.dormhub.exception.AmenityNotFoundException;

import java.util.List;

public interface AmenityService {

    public AmenityResponseDto getAmenityById(long id) throws AmenityNotFoundException;

    public List<AmenityResponseDto> getAllAmenities();

    public void createAmenity(AmenityRequestDto amenityRequestDto) throws AmenityNameMissingException;

}
