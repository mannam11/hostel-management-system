package com.hostelmanagement.dormhub.service.impl;

import com.hostelmanagement.dormhub.dto.city.CityRequestDto;
import com.hostelmanagement.dormhub.dto.city.CityResponseDto;
import com.hostelmanagement.dormhub.exception.CityNameMissingException;
import com.hostelmanagement.dormhub.exception.CityNotFoundException;
import com.hostelmanagement.dormhub.model.City;
import com.hostelmanagement.dormhub.repository.CityRepository;
import com.hostelmanagement.dormhub.service.CityService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CityServiceImpl implements CityService {

    private CityRepository cityRepository;

    @Override
    public CityResponseDto getCityById(long id) throws CityNotFoundException {

        Optional<City> city = cityRepository.findById(id);
        if(city.isEmpty()) {
            throw new CityNotFoundException();
        }

        return convertCityToResponseDto(city.get());
    }

    public CityResponseDto convertCityToResponseDto(City city) {

        return CityResponseDto.builder()
                .name(city.getName())
                .pinCode(city.getPinCode())
                .build();

    }

    @Override
    public List<CityResponseDto> getAllCities() {

        List<City> cities = cityRepository.findAll();

        List<CityResponseDto> citiesDto = new ArrayList<>();
        for (City city : cities) {
            citiesDto.add(convertCityToResponseDto(city));
        }

        return citiesDto;
    }

    @Override
    public void createCity(CityRequestDto cityRequestDto) throws CityNameMissingException {

        if(cityRequestDto.getName().trim().isEmpty()){
            throw new CityNameMissingException();
        }

        String cityName = cityRequestDto.getName().substring(0,1).toUpperCase() + cityRequestDto.getName().substring(1);

        City city = City.builder()
                .name(cityName)
                .pinCode(cityRequestDto.getPinCode())
                .build();

        cityRepository.save(city);
    }
}
