package com.assure.movie.model.domain;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @author Israel Yasis
 */
@Entity
@Table(name = "price")
public class Price implements Identifiable<Long> {

    @Id
    @Column(name="price_id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name = "price",  updatable=false, precision = 12, scale=2)
    private BigDecimal price;

    @OneToOne(mappedBy = "price", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    private MovieCatalog movieCatalog;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public MovieCatalog getMovieCatalog() {
        return movieCatalog;
    }

    public void setMovieCatalog(MovieCatalog movieCatalog) {
        this.movieCatalog = movieCatalog;
    }
}
