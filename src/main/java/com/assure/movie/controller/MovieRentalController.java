package com.assure.movie.controller;

import com.assure.movie.common.converter.MovieRentalConverter;
import com.assure.movie.common.enums.StatusRental;
import com.assure.movie.dto.MovieRentalDTO;
import com.assure.movie.model.domain.MovieRental;
import com.assure.movie.service.MovieRentalService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author Israel Yasis
 */
@RestController
@Api(tags = "Rental Movies")
public class MovieRentalController extends ApiController {

    private MovieRentalConverter  movieRentalConverter;
    private MovieRentalService movieRentalService;

    @Autowired
    public MovieRentalController(
        MovieRentalConverter  movieRentalConverter,
        MovieRentalService movieRentalService
    ) {
        this.movieRentalConverter = movieRentalConverter;
        this.movieRentalService = movieRentalService;
    }

    @RequestMapping(value = "/rentals/", method = RequestMethod.POST)
    public ResponseEntity<MovieRentalDTO> saveMovieRental(@Valid @RequestBody MovieRentalDTO movieRentalDTO) {

        MovieRental movieRental = this.movieRentalConverter.createFrom(movieRentalDTO) ;

        movieRental =  this.movieRentalService.createMovieRental(
            movieRental,
            movieRentalDTO.getMovieId(),
            movieRentalDTO.getMemberId());
        return new ResponseEntity<>(
                HttpStatus.CREATED
        );
    }
    @RequestMapping(value = "/rentals/{id}/status/{statusRental}", method = RequestMethod.PATCH)
    public ResponseEntity<MovieRentalDTO> saveMovieRental(
        @PathVariable(name = "id") Long id,
        @PathVariable(name = "statusRental") StatusRental statusRental
    ) {
        MovieRental movieRental = this.movieRentalService.returnMovieRental(id, statusRental);
        return new ResponseEntity<>(
                HttpStatus.NO_CONTENT
        );
    }

}
