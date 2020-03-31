package com.assure.movie.controller;

import com.assure.movie.common.converter.MovieRentalConverter;
import com.assure.movie.common.enums.StatusRental;
import com.assure.movie.common.response.CreatedResponse;
import com.assure.movie.dto.MovieRentalDTO;
import com.assure.movie.model.domain.MovieRental;
import com.assure.movie.service.MovieRentalService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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

    @RequestMapping(value="/rentals/", method = RequestMethod.GET)
    public ResponseEntity<List<MovieRentalDTO>> getMovieRentals() {
        List<MovieRental> movieRentals = this.movieRentalService.getMovieRentals();
        List<MovieRentalDTO> movieRentalDTOS = this.movieRentalConverter.createFromEntities(movieRentals);
        return new ResponseEntity<>(
                movieRentalDTOS,
                HttpStatus.OK
        );
    }

    @RequestMapping(value = "/rentals/", method = RequestMethod.POST)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ok", response = MovieRentalDTO.class),
            @ApiResponse(code = 201, message = "Created", response = CreatedResponse.class)
    })
    public ResponseEntity<CreatedResponse> saveMovieRental(@Valid @RequestBody MovieRentalDTO movieRentalDTO) {
        MovieRental movieRental = this.movieRentalConverter.createFrom(movieRentalDTO);
        movieRental =  this.movieRentalService.createMovieRental(
            movieRental,
            movieRentalDTO.getMovieId(),
            movieRentalDTO.getMemberId());
        return new ResponseEntity<>(
                (new CreatedResponse(HttpStatus.CREATED.toString(), movieRental.getId())),
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
