package com.assure.movie.model;

import javax.persistence.*;

@Entity
@Table(name = "movie_rental")
public class MovieRental implements Identifiable<Long> {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
