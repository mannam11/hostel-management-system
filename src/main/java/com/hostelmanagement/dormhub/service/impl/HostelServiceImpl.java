package com.hostelmanagement.dormhub.service.impl;

import com.hostelmanagement.dormhub.dto.amenity.AmenityResponseDto;
import com.hostelmanagement.dormhub.dto.hostel.HostelRequestDto;
import com.hostelmanagement.dormhub.dto.hostel.HostelResponseDto;
import com.hostelmanagement.dormhub.exception.AmenityNotFoundException;
import com.hostelmanagement.dormhub.exception.CityNotFoundException;
import com.hostelmanagement.dormhub.exception.HostelNameOrAddressMissingException;
import com.hostelmanagement.dormhub.exception.HostelNotFoundException;
import com.hostelmanagement.dormhub.model.Amenity;
import com.hostelmanagement.dormhub.model.City;
import com.hostelmanagement.dormhub.model.Hostel;
import com.hostelmanagement.dormhub.repository.AmenityRepository;
import com.hostelmanagement.dormhub.repository.CityRepository;
import com.hostelmanagement.dormhub.repository.HostelRepository;
import com.hostelmanagement.dormhub.service.HostelService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@AllArgsConstructor
public class HostelServiceImpl implements HostelService {

    private HostelRepository hostelRepository;
    private CityRepository cityRepository;
    private AmenityRepository amenityRepository;

    @Override
    public void createHostel(HostelRequestDto hostelRequestDto) throws AmenityNotFoundException, CityNotFoundException, HostelNameOrAddressMissingException {

        Hostel hostel = convertHostelRequestDtoToHostel(hostelRequestDto);

        hostelRepository.save(hostel);
    }


    @Override
    public List<HostelResponseDto> getAllHostels() {
        List<Hostel> hostels = hostelRepository.findAll();
        List<HostelResponseDto> hostelResponseDtos = new ArrayList<>();

        for(Hostel hostel : hostels){
            hostelResponseDtos.add(convertHostelToHostelResponseDto(hostel));
        }

        return hostelResponseDtos;
    }

    @Override
    public HostelResponseDto getHostelById(long id) throws HostelNotFoundException {

        Optional<Hostel> hostel = hostelRepository.findById(id);
        if(hostel.isEmpty()){
            throw new HostelNotFoundException();
        }

        return convertHostelToHostelResponseDto(hostel.get());
    }


    public Hostel convertHostelRequestDtoToHostel(HostelRequestDto hostelRequestDto) throws AmenityNotFoundException, CityNotFoundException, HostelNameOrAddressMissingException {
        Set<Amenity> amenities = new HashSet<>();

        for (Long amenityId : hostelRequestDto.getAmenityIds()) {

            Optional<Amenity> amenity = amenityRepository.findById(amenityId);
            if(amenity.isEmpty()){
                throw new AmenityNotFoundException();
            }

            amenities.add(amenity.get());
        }

        Optional<City> city = cityRepository.findById(hostelRequestDto.getCityId());
        if(city.isEmpty()){
            throw new CityNotFoundException();
        }

        if(hostelRequestDto.getName().trim().isEmpty() || hostelRequestDto.getAddress().trim().isEmpty()){
            throw new HostelNameOrAddressMissingException();
        }

        return Hostel.builder()
                .name(hostelRequestDto.getName())
                .address(hostelRequestDto.getAddress())
                .phone(hostelRequestDto.getPhone())
                .singleSharingAvailable(hostelRequestDto.getSingleSharingAvailable())
                .doubleSharingAvailable(hostelRequestDto.getDoubleSharingAvailable())
                .tripleSharingAvailable(hostelRequestDto.getTripleSharingAvailable())
                .amenities(amenities)
                .city(city.get())
                .build();
    }

    public HostelResponseDto convertHostelToHostelResponseDto(Hostel hostel) {

        Set<Amenity> amenities = hostel.getAmenities();

        Set<AmenityResponseDto> amenityResponseDtos = new HashSet<>();

        for (Amenity amenity : amenities) {
            AmenityResponseDto amenityResponseDto = AmenityResponseDto.builder()
                    .name(amenity.getName())
                    .description(amenity.getDescription())
                    .build();

            amenityResponseDtos.add(amenityResponseDto);
        }

        return HostelResponseDto.builder()
                .name(hostel.getName())
                .address(hostel.getAddress())
                .phone(hostel.getPhone())
                .singleSharingAvailable(hostel.getSingleSharingAvailable())
                .doubleSharingAvailable(hostel.getDoubleSharingAvailable())
                .tripleSharingAvailable(hostel.getTripleSharingAvailable())
                .cityName(hostel.getCity().getName())
                .amenities(amenityResponseDtos)
                .build();
    }
}
