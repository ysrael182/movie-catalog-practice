package com.assure.movie.converter;

import com.assure.movie.dto.MovieDTO;
import com.assure.movie.model.domain.Movie;
import org.springframework.stereotype.Component;

@Component
public class MovieConverter implements GenericConverter<Movie, MovieDTO> {

    @Override
    public Movie createFrom(final MovieDTO dto) {
        return updateEntity(new Movie(), dto);
    }
    @Override
    public MovieDTO createFrom(final Movie entity) {
        MovieDTO movieDTO = new MovieDTO();
        movieDTO.setTitle(entity.getTitle());
        return movieDTO;
    }
    @Override
    public Movie updateEntity(final Movie entity,
                                final MovieDTO dto) {
        entity.setTitle(dto.getTitle());
        return entity;
    }
}
