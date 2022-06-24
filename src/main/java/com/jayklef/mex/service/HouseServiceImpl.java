package com.jayklef.mex.service;

import com.jayklef.mex.dto.HouseDTO;
import com.jayklef.mex.entity.House;
import com.jayklef.mex.exception.HouseNotFoundException;
import com.jayklef.mex.repository.HouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class HouseServiceImpl implements HouseService{

    private HouseRepository houseRepository;

    @Autowired
    public HouseServiceImpl(HouseRepository houseRepository) {
        this.houseRepository = houseRepository;
    }

    @Override
    public List<House> findAllHouses() {
        return houseRepository.findAll();
    }

    @Override
    public House saveHouse(HouseDTO houseDTO) {

        House newHouse = House.builder()
                .houseName(houseDTO.getHouseName())
                .build();
        return houseRepository.save(newHouse);
    }

    @Override
    public House updateHouse(Long houseId, House house) {

        House houseInDb = houseRepository.findById(houseId).get();

        if (Objects.nonNull(house.getHouseName()) &&
        !"".equalsIgnoreCase(house.getHouseName())){
            houseInDb.setHouseName(houseInDb.getHouseName());
        }

        if (Objects.nonNull(house.getPrice()) &&
        !"".equalsIgnoreCase(house.getPrice().toString())){
            houseInDb.setPrice(houseInDb.getPrice());
        }

        if (Objects.nonNull(house.getAmenities()) &&
        !"".equalsIgnoreCase(house.getAmenities().toString())){
            houseInDb.setAmenities(houseInDb.getAmenities());
        }

        if (Objects.nonNull(house.getCategory()) &&
        !"".equalsIgnoreCase(house.getCategory().toString())){
            houseInDb.setCategory(houseInDb.getCategory());
        }
        return houseRepository.save(houseInDb);
    }

    @Override
    public House findById(Long houseId) throws HouseNotFoundException {

        Optional<House> house = houseRepository.findById(houseId);

        if (house == null){
            throw new HouseNotFoundException("House not found");
        }
        return houseRepository.findById(houseId).get();
    }
}
