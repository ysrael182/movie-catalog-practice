package com.assure.movie.dto;

import com.assure.movie.common.constraint.ValueOfEnum;
import com.assure.movie.common.enums.Rate;
import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;
/**
 * @author Israel Yasis
 */
public class MovieDTO implements DTO {
    private Long id;
    @NonNull
    private String title;
    @Size(min = 3, max = 255)
    private String description;
    private String registeringUser;
    private String updatingUser;
    private Date year;
    private Rate rate;
    private List<ActorDTO> actors;
    public String getTitle() {
        return title;
    }

    public MovieDTO setTitle(String title) {
        this.title = title;
        return this;
    }

    public Date getYear() {
        return year;
    }

    public void setYear(Date year) {
        this.year = year;
    }

    public Rate getRate() {
        return rate;
    }

    public MovieDTO setRate(Rate rate) {
        this.rate = rate;
        return this;
    }

    public List<ActorDTO> getActors() {
        return actors;
    }

    public MovieDTO setActors(List<ActorDTO> actors) {
        this.actors = actors;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
