package com.jayklef.mex.service;

import com.jayklef.mex.dto.PriceDTO;
import com.jayklef.mex.entity.Price;

import java.util.List;

public interface PriceService {
    List<Price> findAllPrices();

    Price savePrice(PriceDTO priceDTO);

    Price updatePrice(Long priceId, Price price);
}
