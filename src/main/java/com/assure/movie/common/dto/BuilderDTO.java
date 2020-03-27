package com.assure.movie.common.dto;
/**
 * @author Israel Yasis
 */
public interface BuilderDTO<T extends DTO> {
    T build();
}
