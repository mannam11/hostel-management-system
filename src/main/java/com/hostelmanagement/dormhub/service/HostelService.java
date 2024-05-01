package com.hostelmanagement.dormhub.service;

import com.hostelmanagement.dormhub.dto.hostel.HostelRequestDto;
import com.hostelmanagement.dormhub.dto.hostel.HostelResponseDto;
import com.hostelmanagement.dormhub.exception.AmenityNotFoundException;
import com.hostelmanagement.dormhub.exception.CityNotFoundException;
import com.hostelmanagement.dormhub.exception.HostelNameOrAddressMissingException;
import com.hostelmanagement.dormhub.exception.HostelNotFoundException;

import java.util.List;

public interface HostelService {

    public void createHostel(HostelRequestDto hostelRequestDto) throws AmenityNotFoundException, CityNotFoundException, HostelNameOrAddressMissingException;

    public List<HostelResponseDto> getAllHostels();

    public HostelResponseDto getHostelById(long id) throws HostelNotFoundException;
}
