package com.hostelmanagement.dormhub.exception.advice;

import com.hostelmanagement.dormhub.dto.amenity.AmenityNameMissingResponseDto;
import com.hostelmanagement.dormhub.dto.amenity.AmenityNotFoundResponseDto;
import com.hostelmanagement.dormhub.dto.city.CityNameMissingResponseDto;
import com.hostelmanagement.dormhub.dto.city.CityNotFoundResponseDto;
import com.hostelmanagement.dormhub.dto.hostel.HostelNameOrAddressMissingResponseDto;
import com.hostelmanagement.dormhub.dto.hostel.HostelNotFoundResponseDto;
import com.hostelmanagement.dormhub.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler(CityNotFoundException.class)
    public ResponseEntity<CityNotFoundResponseDto> handleCityNotFound(){

        CityNotFoundResponseDto response = CityNotFoundResponseDto.builder()
                .message("City not found")
                .status(HttpStatus.NOT_FOUND)
                .build();

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CityNameMissingException.class)
    public ResponseEntity<CityNameMissingResponseDto> handleCityNameMissing(){

        CityNameMissingResponseDto response = CityNameMissingResponseDto.builder()
                .message("City name is missing")
                .status(HttpStatus.BAD_REQUEST)
                .build();

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(AmenityNotFoundException.class)
    public ResponseEntity<AmenityNotFoundResponseDto> handleAmenityNotFound(){

        AmenityNotFoundResponseDto response = AmenityNotFoundResponseDto.builder()
                .message("Amenity not found")
                .status(HttpStatus.NOT_FOUND)
                .build();

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(AmenityNameMissingException.class)
    public ResponseEntity<AmenityNameMissingResponseDto> handleAmenityNameMissing(){

        AmenityNameMissingResponseDto response = AmenityNameMissingResponseDto.builder()
                .message("Amenity name is missing")
                .status(HttpStatus.BAD_REQUEST)
                .build();

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HostelNameOrAddressMissingException.class)
    public ResponseEntity<HostelNameOrAddressMissingResponseDto> handleHostelNameOrAddressMissing(){

        HostelNameOrAddressMissingResponseDto response = HostelNameOrAddressMissingResponseDto.builder()
                .message("Hostel name or address is missing")
                .status(HttpStatus.BAD_REQUEST)
                .build();

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HostelNotFoundException.class)
    public ResponseEntity<HostelNotFoundResponseDto> handleHostelNotFound(){

        HostelNotFoundResponseDto response = HostelNotFoundResponseDto.builder()
                .message("Hostel not found")
                .status(HttpStatus.NOT_FOUND)
                .build();

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

}
