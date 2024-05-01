package com.hostelmanagement.dormhub.repository;

import com.hostelmanagement.dormhub.model.Amenity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AmenityRepository extends JpaRepository<Amenity, Long> {
}
