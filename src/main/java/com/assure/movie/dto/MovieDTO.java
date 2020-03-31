package com.assure.movie.dto;

import com.assure.movie.common.enums.Rate;
import java.util.Date;
import java.util.List;
/**
 * @author Israel Yasis
 */
public class MovieDTO implements DTO {
    private String title;
    private String year;
    private Rate rate;
    private Date availableDate;
    private int numberOfCopies;
    private List<ActorDTO> actors;

    public String getTitle() {
        return title;
    }

    public MovieDTO setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getYear() {
        return year;
    }

    public MovieDTO setYear(String year) {
        this.year = year;
        return this;
    }

    public Rate getRate() {
        return rate;
    }

    public MovieDTO setRate(Rate rate) {
        this.rate = rate;
        return this;
    }

    public Date getAvailableDate() {
        return availableDate;
    }

    public MovieDTO setAvailableDate(Date availableDate) {
        this.availableDate = availableDate;
        return this;
    }

    public int getNumberOfCopies() {
        return numberOfCopies;
    }

    public MovieDTO setNumberOfCopies(int numberOfCopies) {
        this.numberOfCopies = numberOfCopies;
        return this;
    }

    public List<ActorDTO> getActors() {
        return actors;
    }

    public MovieDTO setActors(List<ActorDTO> actors) {
        this.actors = actors;
        return this;
    }
}
