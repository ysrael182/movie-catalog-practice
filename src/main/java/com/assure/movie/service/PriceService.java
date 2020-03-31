package com.assure.movie.service;

import com.assure.movie.common.errors.NotFoundErrorException;
import com.assure.movie.model.domain.Price;
import com.assure.movie.model.repository.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author Israel Yasis
 */
@Service
public class PriceService {
    private PriceRepository priceRepository;
    @Autowired
    public PriceService(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    public Price getPrice(Long id) throws NotFoundErrorException {
        return this.priceRepository.findById(id).orElseThrow(()
                -> new NotFoundErrorException("Not found movie with id: "+ id));
    }

    public List<Price> getPrices() {
        return this.priceRepository.findAll();
    }
}
