package com.assure.movie.common.converter;

import com.assure.movie.dto.MovieCatalogDTO;
import com.assure.movie.model.domain.MovieCatalog;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

/**
 * @author Israel Yasis
 */
@Component
@RequestScope
public class MovieCatalogConverter implements GenericConverter<MovieCatalog, MovieCatalogDTO> {

    @Override
    public MovieCatalog createFrom(final MovieCatalogDTO dto) {
        return updateEntity(new MovieCatalog(), dto);
    }

    @Override
    public MovieCatalogDTO createFrom(final MovieCatalog entity) {
        MovieCatalogDTO movieCatalogDTO = new MovieCatalogDTO();
        return movieCatalogDTO;
    }
    @Override
    public MovieCatalog updateEntity(final MovieCatalog entity,
                                final MovieCatalogDTO dto) {
        entity.setNumberCopies(dto.getNumberOfCopies());
        return entity;
    }
}
