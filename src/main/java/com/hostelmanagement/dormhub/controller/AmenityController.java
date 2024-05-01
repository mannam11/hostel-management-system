package com.hostelmanagement.dormhub.controller;

import com.hostelmanagement.dormhub.dto.amenity.AmenityRequestDto;
import com.hostelmanagement.dormhub.dto.amenity.AmenityResponseDto;
import com.hostelmanagement.dormhub.exception.AmenityNameMissingException;
import com.hostelmanagement.dormhub.exception.AmenityNotFoundException;
import com.hostelmanagement.dormhub.service.AmenityService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/amenity")
public class AmenityController {

    private AmenityService amenityService;

    @PostMapping("/")
    public ResponseEntity<String> addAmenity(@RequestBody AmenityRequestDto amenityRequestDto) throws AmenityNameMissingException {
        amenityService.createAmenity(amenityRequestDto);
        return new ResponseEntity<>("Amenity added successfully", HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<AmenityResponseDto>> getAllCities() {
        return new ResponseEntity<>(amenityService.getAllAmenities(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AmenityResponseDto> getAmenityById(@PathVariable long id) throws AmenityNotFoundException {
        return new ResponseEntity<>(amenityService.getAmenityById(id),HttpStatus.OK);
    }

}
