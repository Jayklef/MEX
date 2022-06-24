package com.jayklef.mex.controller;

import com.jayklef.mex.dto.HouseDTO;
import com.jayklef.mex.entity.House;
import com.jayklef.mex.exception.HouseNotFoundException;
import com.jayklef.mex.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/houses")
public class HouseController {

    private HouseService houseService;

    @Autowired
    public HouseController(HouseService houseService) {
        this.houseService = houseService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<House>> getAllHouse(){
        List<House> houses = houseService.findAllHouses();
        return new ResponseEntity<>(houses, HttpStatus.OK);
    }

    @PostMapping("/new")
    public ResponseEntity<House> saveHouse(@RequestBody HouseDTO houseDTO){
        House newHouse = houseService.saveHouse(houseDTO);
        return new ResponseEntity<>(newHouse, HttpStatus.CREATED);
    }

    @PutMapping("/update/{houseId}")
    public ResponseEntity<House> updateHouse(@PathVariable("houseId") Long houseId,
                                             @RequestBody House house){
        House updatedHouse = houseService.updateHouse(houseId, house);
        return new ResponseEntity<>(updatedHouse, HttpStatus.OK);
    }

    @GetMapping("/single/{houseId}")
    public ResponseEntity<House> getHouseById(@PathVariable("houseId") Long houseId) throws HouseNotFoundException {
        House house = houseService.findById(houseId);
        return new ResponseEntity<>(house, HttpStatus.OK);
    }
}
