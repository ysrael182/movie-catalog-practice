package com.assure.movie.model;

import javax.persistence.*;

@Entity
@Table(name = "movie_catalog")
public class MovieCatalog implements Identifiable<Long> {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(name = "number_copies")
    private int numberCopies;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumberCopies() {
        return numberCopies;
    }

    public void setNumberCopies(int numberCopies) {
        this.numberCopies = numberCopies;
    }
}
