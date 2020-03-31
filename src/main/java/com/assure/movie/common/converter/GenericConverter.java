package com.assure.movie.common.converter;

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

    default List<D> createFromEntities(final Collection<E> entities) {
        return entities.stream()
                .map(entity -> this.createFrom(entity))
                .collect(Collectors.toList());
    }

    default List<E> createFromDtos(final Collection<D> dtos) {
        return dtos.stream()
                .map(dto -> this.createFrom(dto))
                .collect(Collectors.toList());
    }
}
