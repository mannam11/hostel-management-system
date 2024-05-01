package com.hostelmanagement.dormhub.service;

import com.hostelmanagement.dormhub.dto.city.CityRequestDto;
import com.hostelmanagement.dormhub.dto.city.CityResponseDto;
import com.hostelmanagement.dormhub.exception.CityNameMissingException;
import com.hostelmanagement.dormhub.exception.CityNotFoundException;

import java.util.List;

public interface CityService {

    public CityResponseDto getCityById(long id) throws CityNotFoundException;

    public List<CityResponseDto> getAllCities();

    public void createCity(CityRequestDto cityRequestDto) throws CityNameMissingException;
}
