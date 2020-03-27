package com.assure.movie.dto;

import com.assure.movie.common.Rate;

import java.util.Date;
import java.util.List;

public class Movie {
    private String title;
    private String year;
    private Rate rate;
    private Date availableDate;
    private int numberOfCopies;
    private List<Actor> actors;
}
