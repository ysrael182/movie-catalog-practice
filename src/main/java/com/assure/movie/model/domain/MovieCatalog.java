package com.assure.movie.model.domain;

import com.assure.movie.model.domain.embedable.MovieCatalogId;

import javax.persistence.*;

@Entity
@Table(name = "movie_catalog")
public class MovieCatalog implements Identifiable<MovieCatalogId> {
    @EmbeddedId
    private MovieCatalogId id;

    @MapsId("id")
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(
                    name = "movie_id",
                    referencedColumnName = "movie_id")
    })
    private Movie movie;

    @Column(name = "number_copies")
    private int numberCopies;

    public MovieCatalogId getId() {
        return id;
    }

    public void setId(MovieCatalogId id) {
        this.id = id;
    }

    public int getNumberCopies() {
        return numberCopies;
    }

    public void setNumberCopies(int numberCopies) {
        this.numberCopies = numberCopies;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
}
