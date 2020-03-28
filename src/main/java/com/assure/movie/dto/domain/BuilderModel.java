package com.assure.movie.dto.domain;

import com.assure.movie.model.domain.Identifiable;
/**
 * @author Israel Yasis
 */
public interface BuilderModel<T extends Identifiable> {
    T build();
}
