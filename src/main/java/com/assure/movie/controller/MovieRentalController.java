package com.assure.movie.controller;

import com.assure.movie.common.converter.MovieRentalConverter;
import com.assure.movie.common.enums.StatusRental;
import com.assure.movie.dto.MovieRentalDTO;
import com.assure.movie.model.domain.Member;
import com.assure.movie.model.domain.Movie;
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
        Movie movie = this.movieService.getMovie(movieRentalDTO.getMovieId());
        Member member = this.memberService.getMember(movieRentalDTO.getMemberId());
        MovieRental movieRental =  this.movieRentalConverter.createFrom(movieRentalDTO);
        movieRental.setMember(member);
        movieRental.setMovie(movie);
        this.movieRentalService.saveMovieRental(movieRental);
        return new ResponseEntity<>(
                HttpStatus.CREATED
        );
    }
    @RequestMapping(value = "/rentals/{id}", method = RequestMethod.PATCH)
    public ResponseEntity<MovieRentalDTO> saveMovieRental(
        @PathVariable(name = "id") Long id,
        @PathVariable StatusRental statusRental
    ) {
        return new ResponseEntity<>(
                HttpStatus.NO_CONTENT
        );
    }

}
