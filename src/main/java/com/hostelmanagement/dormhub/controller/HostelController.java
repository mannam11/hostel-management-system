package com.hostelmanagement.dormhub.controller;

import com.hostelmanagement.dormhub.dto.hostel.HostelRequestDto;
import com.hostelmanagement.dormhub.dto.hostel.HostelResponseDto;
import com.hostelmanagement.dormhub.exception.HostelNotFoundException;
import com.hostelmanagement.dormhub.service.HostelService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/hostel")
public class HostelController {

    private HostelService hostelService;

    @PostMapping("/")
    private ResponseEntity<String> addHostel(@RequestBody HostelRequestDto hostelRequestDto) throws Exception{
        hostelService.createHostel(hostelRequestDto);
        return new ResponseEntity<>("Hostel is added successfully", HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<HostelResponseDto>> getAllHostels() {
        return new ResponseEntity<>(hostelService.getAllHostels(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HostelResponseDto> getHostelById(@PathVariable long id) throws HostelNotFoundException {
        return new ResponseEntity<>(hostelService.getHostelById(id),HttpStatus.OK);
    }

}
