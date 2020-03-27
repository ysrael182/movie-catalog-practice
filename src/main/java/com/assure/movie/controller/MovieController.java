package com.assure.movie.controller;

import com.assure.movie.common.dto.MovieDTO;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Israel Yasis
 */
@RestController
public class MovieController {

    @RequestMapping(value = "/movies/{id}", method = RequestMethod.GET)
    public ResponseEntity<MovieDTO> getMovie(@PathVariable Long id) {
        //Todo: non implemented yet
        return null;
    }
    @RequestMapping(value = "/movies", method = RequestMethod.GET)
    @ApiResponses(value = {
        @ApiResponse(code = 404, message = "Movies not found")
    })
    public ResponseEntity<List<MovieDTO>> getMovies() {
        return null;
    }

    @RequestMapping(value = "/movies", method = RequestMethod.POST)
    public ResponseEntity<MovieDTO> createMovie(@RequestBody MovieDTO movie) {
        //Todo: non implemented yet
        return null;
    }
}
