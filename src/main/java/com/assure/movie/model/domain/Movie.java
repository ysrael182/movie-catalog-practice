package com.assure.movie.model.domain;

import com.assure.movie.common.enums.Rate;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "movie")
public class Movie implements Identifiable<Long> {

    @Id
    @Column(name="movie_id")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(name = "title", length = 100, nullable = false)
    private String title;

    @Temporal(TemporalType.DATE)
    @Column(name = "year")
    private Date year;

    @Column(name = "description", length = 255, nullable = true)
    private String description;

    @Column(name = "rate", length = 10, nullable = false)
    @Enumerated(EnumType.STRING)
    private Rate rate;

    @Column(name = "registering_user", length = 255, nullable = false)
    private String registeringUser;

    @Column(name = "updating_user", length = 255, nullable = false)
    private String updatingUser;

    @Column(name="deleted", columnDefinition="tinyint(1) default 0")
    private boolean deleted;

    @ManyToMany(mappedBy = "movies")
    private Set<Actor> actors;

    @OneToOne(mappedBy = "movie", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    private MovieCatalog member;

    @OneToOne(mappedBy = "member", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    private MovieRental movieRental;

    public void addActor(Actor actor) {
        this.actors.add(actor);
        actor.getMovies().add(this);
    }

    public void removeActor(Actor actor) {
        this.actors.remove(actor);
        actor.getMovies().remove(this);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getYear() {
        return this.year;
    }

    public void setYear(Date year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Rate getRate() {
        return rate;
    }

    public void setRate(Rate rate) {
        this.rate = rate;
    }

    public String getRegisteringUser() {
        return registeringUser;
    }

    public void setRegisteringUser(String registeringUser) {
        this.registeringUser = registeringUser;
    }

    public String getUpdatingUser() {
        return updatingUser;
    }

    public void setUpdatingUser(String updatingUser) {
        this.updatingUser = updatingUser;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public Set<Actor> getActors() {
        return actors;
    }

    public void setActors(Set<Actor> actors) {
        this.actors = actors;
    }

    public MovieCatalog getMember() {
        return member;
    }

    public void setMember(MovieCatalog member) {
        this.member = member;
    }

    public MovieRental getMovieRental() {
        return movieRental;
    }

    public void setMovieRental(MovieRental movieRental) {
        this.movieRental = movieRental;
    }
}
