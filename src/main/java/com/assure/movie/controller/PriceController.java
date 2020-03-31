package com.assure.movie.controller;

import com.assure.movie.common.converter.PriceConverter;
import com.assure.movie.dto.PriceDTO;
import com.assure.movie.service.PriceService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @author Israel Yasis
 */
@RestController
@Api(tags = "Prices")
public class PriceController extends ApiController {

    private PriceService priceService;

    private PriceConverter priceConverter;

    @Autowired
    public PriceController(
            PriceService priceService,
            PriceConverter priceConverter
    ) {
        this.priceService = priceService;
        this.priceConverter = priceConverter;
    }

    @RequestMapping(value = "/prices/", method = RequestMethod.GET)
    public ResponseEntity<List<PriceDTO>> getPrices() {
        List<PriceDTO> priceDTOS = this.priceConverter.createFromEntities(this.priceService.getPrices());
        return new ResponseEntity<>(
                priceDTOS,
                HttpStatus.OK
        );
    }
}
