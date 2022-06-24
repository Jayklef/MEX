package com.jayklef.mex.service;

import com.jayklef.mex.dto.AmenitiesDTO;
import com.jayklef.mex.entity.Amenities;
import com.jayklef.mex.exception.AmenitiesNotFoundException;

import java.util.List;

public interface AmenitiesService {
    List<Amenities> findAll();

    Amenities saveAmenities(AmenitiesDTO amenitiesDTO);

    Amenities updateAmenities(Long id, Amenities amenities);

    Amenities findById(Long id) throws AmenitiesNotFoundException;
}
