package com.assure.movie.controller;

import com.assure.movie.dto.Movie;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController {

    @RequestMapping(value = "/movies", method = RequestMethod.GET)
    public void getMovies() {
        //Todo: non implemented yet
    }

    @RequestMapping(value = "/movies", method = RequestMethod.POST)
    public void createMovie(@RequestBody Movie movie) {
        //Todo: non implemented yet
    }
}
