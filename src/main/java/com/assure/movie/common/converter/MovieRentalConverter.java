package com.assure.movie.common.converter;

import com.assure.movie.dto.MovieRentalDTO;
import com.assure.movie.model.domain.MovieRental;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

/**
 * @author Israel Yasis
 */
@Component
@RequestScope
public class MovieRentalConverter implements GenericConverter<MovieRental, MovieRentalDTO> {

    @Override
    public MovieRental createFrom(final MovieRentalDTO dto) {
        return updateEntity(new MovieRental(), dto);
    }

    @Override
    public MovieRentalDTO createFrom(final MovieRental entity) {
        MovieRentalDTO movieRentalDTO = new MovieRentalDTO();
        movieRentalDTO.setId(entity.getId());
        movieRentalDTO.setDate(entity.getDate());
        movieRentalDTO.setReturnDate(entity.getReturnDate());
        movieRentalDTO.setReturnedDate(entity.getReturnedDate());
        movieRentalDTO.setStatusRental(entity.getStatusRental());
        if(entity.getMember() != null) {
            movieRentalDTO.setMemberId(entity.getMember().getId());
        }
        if(entity.getMovieCatalog() != null) {
            movieRentalDTO.setMovieId(entity.getMovieCatalog().getId().getMovieId());
        }
        return movieRentalDTO;
    }
    @Override
    public MovieRental updateEntity(final MovieRental entity,
                                final MovieRentalDTO dto) {
        entity.setDate(dto.getDate());
        entity.setReturnDate(dto.getReturnDate());
        entity.setReturnedDate(dto.getReturnedDate());
        entity.setStatusRental(dto.getStatusRental());
        return entity;
    }
}
