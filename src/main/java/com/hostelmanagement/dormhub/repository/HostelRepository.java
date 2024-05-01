package com.hostelmanagement.dormhub.repository;

import com.hostelmanagement.dormhub.model.Hostel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HostelRepository extends JpaRepository<Hostel, Long> {

}
