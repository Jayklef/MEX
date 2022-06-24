package com.jayklef.mex.service;

import com.jayklef.mex.dto.AmenitiesDTO;
import com.jayklef.mex.entity.Amenities;
import com.jayklef.mex.exception.AmenitiesNotFoundException;
import com.jayklef.mex.repository.AmenitiesRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class AmenitiesServiceImpl implements AmenitiesService{

    private AmenitiesRepository amenitiesRepository;

    public AmenitiesServiceImpl(AmenitiesRepository amenitiesRepository) {
        this.amenitiesRepository = amenitiesRepository;
    }

    @Override
    public List<Amenities> findAll() {
        return amenitiesRepository.findAll();
    }

    @Override
    public Amenities saveAmenities(AmenitiesDTO amenitiesDTO) {

        Amenities newAmenity = Amenities.builder()
                .name(amenitiesDTO.getName())
                .build();
        return amenitiesRepository.save(newAmenity);
    }

    @Override
    public Amenities updateAmenities(Long id, Amenities amenities) {

        Amenities amenitiesInDb = amenitiesRepository.findById(id).get();

        if (Objects.nonNull(amenities.getName())&&
        !"".equalsIgnoreCase(amenities.getName())){
            amenitiesInDb.setName(amenitiesInDb.getName());
        }

        return amenitiesRepository.save(amenitiesInDb);
    }

    @Override
    public Amenities findById(Long id) throws AmenitiesNotFoundException {

        Optional<Amenities> amenities = amenitiesRepository.findById(id);

        if (id == null){
            throw new AmenitiesNotFoundException("Amenity not found");
        }
        return amenitiesRepository.findById(id).get();
    }
}
