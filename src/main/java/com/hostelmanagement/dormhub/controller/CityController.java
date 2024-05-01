package com.hostelmanagement.dormhub.controller;

import com.hostelmanagement.dormhub.dto.city.CityRequestDto;
import com.hostelmanagement.dormhub.dto.city.CityResponseDto;
import com.hostelmanagement.dormhub.exception.CityNameMissingException;
import com.hostelmanagement.dormhub.exception.CityNotFoundException;
import com.hostelmanagement.dormhub.service.CityService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/city")
@AllArgsConstructor
public class CityController {

    private CityService cityService;

    @PostMapping("/")
    public ResponseEntity<String> addCity(@RequestBody CityRequestDto cityRequestDto) throws CityNameMissingException {
        cityService.createCity(cityRequestDto);
        return new ResponseEntity<>("City added successfully", HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<CityResponseDto>> getAllCities() {
        return new ResponseEntity<>(cityService.getAllCities(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CityResponseDto> getCityById(@PathVariable long id) throws CityNotFoundException {
        return new ResponseEntity<>(cityService.getCityById(id),HttpStatus.OK);
    }

}
