package com.assure.movie.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "movie")
public class Movie implements Identifiable<Long> {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(name = "title", length = 100, nullable = false)
    private String title;

    @Temporal(TemporalType.DATE)
    private Date dob;

    @Column(name = "description", length = 255, nullable = true)
    private String description;

    @Column(columnDefinition = "SMALLINT", name = "rate", nullable = true)
    @Type(type = "org.hibernate.type.ShortType")
    private short rate;

    @Column(name = "registering_user", length = 255, nullable = false)
    private String registeringUser;

    @Column(name = "updating_user", length = 255, nullable = false)
    private String updatingUser;

    @Column(columnDefinition="tinyint(1) default 0")
    private boolean deleted;

    @ManyToMany(mappedBy = "movies")
    private Set<Actor> actors;

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

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public short getRate() {
        return rate;
    }

    public void setRate(short rate) {
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
}
