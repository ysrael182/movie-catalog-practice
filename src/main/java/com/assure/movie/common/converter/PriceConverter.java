package com.assure.movie.common.converter;

import com.assure.movie.dto.PriceDTO;
import com.assure.movie.model.domain.Price;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import java.math.BigDecimal;

@Component
@RequestScope
public class PriceConverter implements GenericConverter<Price, PriceDTO> {

    @Override
    public Price createFrom(final PriceDTO dto) {
        return updateEntity(new Price(), dto);
    }

    @Override
    public PriceDTO createFrom(final Price entity) {
        PriceDTO priceDTO = new PriceDTO();
        priceDTO.setId(entity.getId());
        priceDTO.setPrice(entity.getPrice().doubleValue());
        return priceDTO;
    }
    @Override
    public Price updateEntity(final Price entity,
                                final PriceDTO dto) {
        entity.setId(dto.getId());
        entity.setPrice(new BigDecimal(dto.getPrice()));
        return entity;
    }
}
