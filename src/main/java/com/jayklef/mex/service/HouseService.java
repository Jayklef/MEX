package com.jayklef.mex.service;

import com.jayklef.mex.dto.HouseDTO;
import com.jayklef.mex.entity.House;
import com.jayklef.mex.exception.HouseNotFoundException;

import java.util.List;

public interface HouseService {
    List<House> findAllHouses();

    House saveHouse(HouseDTO houseDTO);

    House updateHouse(Long houseId, House house);

    House findById(Long houseId) throws HouseNotFoundException;
}
