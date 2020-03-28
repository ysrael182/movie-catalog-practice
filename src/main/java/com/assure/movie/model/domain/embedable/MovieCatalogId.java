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

    private Long movieCatalogId;

}
