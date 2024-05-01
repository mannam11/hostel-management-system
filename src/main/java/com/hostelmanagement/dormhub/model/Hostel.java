package com.hostelmanagement.dormhub.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Hostel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String address;

    private String phone;

    private Integer singleSharingAvailable;

    private Integer doubleSharingAvailable;

    private Integer tripleSharingAvailable;

    @ManyToOne
    private City city;

    @ManyToMany
    @JoinTable(
            name = "hostels_amenities",
            joinColumns = @JoinColumn(name = "hostel_id"),
            inverseJoinColumns = @JoinColumn(name = "amenity_id")
    )
    private Set<Amenity> amenities;

}
