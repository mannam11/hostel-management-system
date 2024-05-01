package com.hostelmanagement.dormhub.repository;

import com.hostelmanagement.dormhub.model.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Long> {
}
