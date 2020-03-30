package com.assure.movie.controller;

import com.assure.movie.common.converter.ActorConverter;
import com.assure.movie.common.converter.MovieConverter;
import com.assure.movie.dto.ActorDTO;
import com.assure.movie.dto.MovieDTO;
import com.assure.movie.dto.domain.BuilderMovieModel;
import com.assure.movie.model.domain.Actor;
import com.assure.movie.model.domain.Movie;
import com.assure.movie.service.MovieService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author Israel Yasis
 */
@RestController
public class MovieCatalogController extends ApiController {


    @RequestMapping(value = "/catalog-entries/movies/{movieId}/prices/{priceId}", method = RequestMethod.POST)
    public ResponseEntity<MovieDTO> getMovie(
            @PathVariable("movieId") Long movieId,
            @PathVariable("priceId") Long PriceId
    ) {
        return  null;
    }

}
