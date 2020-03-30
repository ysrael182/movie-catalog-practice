package com.assure.movie.controller;

import com.assure.movie.common.converter.MovieRentalConverter;
import com.assure.movie.common.enums.StatusRental;
import com.assure.movie.dto.MovieRentalDTO;
import com.assure.movie.model.domain.Member;
import com.assure.movie.model.domain.Movie;
import com.assure.movie.model.domain.MovieCatalog;
import com.assure.movie.model.domain.MovieRental;
import com.assure.movie.service.MemberService;
import com.assure.movie.service.MovieRentalService;
import com.assure.movie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author Israel Yasis
 */
@RestController
public class MovieRentalController extends ApiController {

    private MovieRentalConverter  movieRentalConverter;
    private MovieRentalService movieRentalService;
    private MemberService memberService;
    private MovieService movieService;

    @Autowired
    public MovieRentalController(
        MovieRentalConverter  movieRentalConverter,
        MovieRentalService movieRentalService,
        MovieService movieService,
        MemberService memberService
    ) {
        this.movieRentalConverter = movieRentalConverter;
        this.movieRentalService = movieRentalService;
        this.movieService = movieService;
        this.memberService = memberService;
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
