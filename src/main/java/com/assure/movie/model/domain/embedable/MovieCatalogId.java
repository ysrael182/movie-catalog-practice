package com.assure.movie.model.domain.embedable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * @author Israel Yasis
 */
@Embeddable
public class MovieCatalogId implements Serializable {

    @Column(name = "movie_id")
    private Long movieId;

    public MovieCatalogId() {

    }
    public MovieCatalogId(Long movieId) {
        this.movieId =  movieId;
    }
    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }
}
