package com.jayklef.mex.controller;

import com.jayklef.mex.dto.PriceDTO;
import com.jayklef.mex.entity.Price;
import com.jayklef.mex.service.PriceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/prices")
public class PriceController {

    private PriceService priceService;

    @GetMapping("/all")
    public ResponseEntity<List<Price>> getAllPrices(){
        List<Price> priceList = priceService.findAllPrices();
        return new ResponseEntity<>(priceList, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Price> savePrice(@RequestBody PriceDTO priceDTO){
        Price newPrice = priceService.savePrice(priceDTO);
        return new ResponseEntity<>(newPrice, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Price> updatePrice(@PathVariable("priceId") Long priceId,
                                             @RequestBody Price price){
        Price updatePriced = priceService.updatePrice(priceId, price);
        return new ResponseEntity<>(updatePriced, HttpStatus.OK);
    }
}
