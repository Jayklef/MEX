package com.jayklef.mex.service;

import com.jayklef.mex.dto.PriceDTO;
import com.jayklef.mex.entity.Price;
import com.jayklef.mex.repository.PriceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class PriceServiceImpl implements PriceService{

    private PriceRepository priceRepository;

    public PriceServiceImpl(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    @Override
    public List<Price> findAllPrices() {
        return priceRepository.findAll();
    }

    @Override
    public Price savePrice(PriceDTO priceDTO) {

        Price newPrice = Price.builder()
                .amount(priceDTO.getAmount())
                .build();
        return priceRepository.save(newPrice);
    }

    @Override
    public Price updatePrice(Long priceId, Price price) {

        Price priceInDb = priceRepository.findById(priceId).get();
        if (Objects.nonNull(price.getAmount()) &&
        !"".equalsIgnoreCase(price.getAmount().toString())){{
        }
        }

        return priceRepository.save(priceInDb);
    }
}
