package com.jayklef.mex.controller;

import com.jayklef.mex.dto.AmenitiesDTO;
import com.jayklef.mex.entity.Amenities;
import com.jayklef.mex.service.AmenitiesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/amenities")
public class AmenitiesController {

    private AmenitiesService amenitiesService;

    public AmenitiesController(AmenitiesService amenitiesService) {
        this.amenitiesService = amenitiesService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Amenities>> getAllAmenities(){
        List<Amenities> amenitiesList = amenitiesService.findAll();
        return new ResponseEntity<>(amenitiesList, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Amenities> saveAmenities(@RequestBody AmenitiesDTO amenitiesDTO){
        Amenities newAmenities = amenitiesService.saveAmenities(amenitiesDTO);
        return new ResponseEntity<>(newAmenities, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Amenities> updateAmenities(@PathVariable("id") Long id,
                                                     @RequestBody Amenities amenities){
        Amenities updatedAmenities = amenitiesService.updateAmenities(id, amenities);
        return new ResponseEntity<>(updatedAmenities, HttpStatus.OK);
    }

    @GetMapping("/single")
    public ResponseEntity<Amenities> findById(@PathVariable("id") Long id){
        Amenities amenities = amenitiesService.findById(id);
        return new ResponseEntity<>(amenities, HttpStatus.OK);
    }
}
