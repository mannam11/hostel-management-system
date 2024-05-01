package com.hostelmanagement.dormhub.service.impl;

import com.hostelmanagement.dormhub.dto.amenity.AmenityRequestDto;
import com.hostelmanagement.dormhub.dto.amenity.AmenityResponseDto;
import com.hostelmanagement.dormhub.exception.AmenityNameMissingException;
import com.hostelmanagement.dormhub.exception.AmenityNotFoundException;
import com.hostelmanagement.dormhub.model.Amenity;
import com.hostelmanagement.dormhub.repository.AmenityRepository;
import com.hostelmanagement.dormhub.service.AmenityService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class AmenityServiceImpl implements AmenityService {

    private AmenityRepository amenityRepository;

    @Override
    public AmenityResponseDto getAmenityById(long id) throws AmenityNotFoundException {

        Optional<Amenity> amenity = amenityRepository.findById(id);
        if(amenity.isEmpty()){
            throw new AmenityNotFoundException();
        }

        return convertAmenityToAmenityResponseDto(amenity.get());
    }

    public AmenityResponseDto convertAmenityToAmenityResponseDto(Amenity amenity) {

        return AmenityResponseDto.builder()
                .name(amenity.getName())
                .description(amenity.getDescription())
                .build();
    }

    @Override
    public List<AmenityResponseDto> getAllAmenities() {

        List<Amenity> amenities = amenityRepository.findAll();

        List<AmenityResponseDto> amenityResponseDtos = new ArrayList<>();

        for(Amenity amenity : amenities) {
            amenityResponseDtos.add(convertAmenityToAmenityResponseDto(amenity));
        }

        return amenityResponseDtos;
    }

    @Override
    public void createAmenity(AmenityRequestDto amenityRequestDto) throws AmenityNameMissingException {

        if(amenityRequestDto.getName().trim().isEmpty()){
            throw new AmenityNameMissingException();
        }

        Amenity amenity = Amenity.builder()
                .name(amenityRequestDto.getName())
                .description(amenityRequestDto.getDescription())
                .build();

        amenityRepository.save(amenity);

    }
}
