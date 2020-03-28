package com.assure.movie.converter;

import com.assure.movie.dto.DTO;
import com.assure.movie.model.domain.Identifiable;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Israel Yasis
 */
public interface GenericConverter<E extends Identifiable, D extends DTO> {

    E createFrom(D dto);

    D createFrom(E entity);

    E updateEntity(E entity, D dto);
    /*
    default List createFromEntities(final Collection entities) {
        return entities.stream()
                .map(this::createFrom)
                .collect(Collectors.toList());
    }

    default List createFromDtos(final Collection dtos) {
        return dtos.stream()
                .map(this::createFrom)
                .collect(Collectors.toList());
    }*/
}
