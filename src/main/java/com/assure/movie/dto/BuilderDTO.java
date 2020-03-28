package com.assure.movie.dto;
/**
 * @author Israel Yasis
 */
public interface BuilderDTO<T extends DTO> {
    T build();
}
