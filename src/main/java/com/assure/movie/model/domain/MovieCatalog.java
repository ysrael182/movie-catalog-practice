package com.assure.movie.model.domain;

import com.assure.movie.model.domain.embedable.MovieCatalogId;

import javax.persistence.*;

@Entity
@Table(
    name = "movie_catalog",
    uniqueConstraints= @UniqueConstraint(columnNames={"movie_id"})
)
public class MovieCatalog implements Identifiable<MovieCatalogId> {
    @EmbeddedId
    @Column(name = "movie_catalog_id")
    private MovieCatalogId id;

    @MapsId("id")
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(
            name = "movie_id",
            referencedColumnName = "movie_id")
    })
    private Movie movie;

    @MapsId("id")
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(
            name = "price_id",
            referencedColumnName = "price_id")
    })
    private Price price;

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

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }
}
