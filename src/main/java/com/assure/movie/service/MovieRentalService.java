package com.assure.movie.service;

import com.assure.movie.common.enums.StatusRental;
import com.assure.movie.common.errors.NotFoundErrorException;
import com.assure.movie.model.domain.MovieCatalog;
import com.assure.movie.model.domain.MovieRental;
import com.assure.movie.model.repository.MovieRentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author Israel Yasis
 */
@Service
public class MovieRentalService {

    private final static int DAYS_TO_RETURN = 3;

    private MovieRentalRepository movieRentalRepository;
    private MovieService movieService;
    private MemberService memberService;
    private MovieCatalogService movieCatalogService;

    @Autowired
    public MovieRentalService(
        MovieRentalRepository movieRentalRepository,
        MovieService movieService,
        MemberService memberService,
        MovieCatalogService movieCatalogService
    ) {
        this.memberService = memberService;
        this.movieService = movieService;
        this.movieRentalRepository = movieRentalRepository;
        this.movieCatalogService = movieCatalogService;
    }
    private MovieRental getMovieRental(Long id) throws NotFoundErrorException {
        return this.movieRentalRepository.findById(id).orElseThrow( ()
                -> new NotFoundErrorException("Not found movie rental with id: "+ id));
    }

    public List<MovieRental> getMovieRentals() {
        return this.movieRentalRepository.findAll();
    }

    public MovieRental returnMovieRental(Long id, StatusRental statusRental) {
        MovieRental movieRental = this.getMovieRental(id);
        movieRental.setStatusRental(StatusRental.RETURNED);
        MovieCatalog movieCatalog = movieRental.getMovieCatalog();
        movieCatalog.setNumberCopies(movieCatalog.getNumberCopies()  + 1);
        movieRental.setMovieCatalog(movieCatalog);
        movieRental.setReturnedDate(new Date());
        return this.saveMovieRental(movieRental);
    }

    @Transactional
    public MovieRental createMovieRental(
        MovieRental movieRental,
        Long movieId,
        Long memberId
    ) throws NotFoundErrorException {
        MovieCatalog movieCatalog = this.movieService.getMovie(movieId).getMovieCatalog();
        if(movieCatalog == null) {
            throw new NotFoundErrorException("Not found movie catalog with id: "+ movieId);
        }
        movieCatalog.setNumberCopies(movieCatalog.getNumberCopies() - 1);
        this.movieCatalogService.saveMovieCatalog(movieCatalog);
        movieRental.setMember(this.memberService.getMember(memberId));
        movieRental.setMovieCatalog(movieCatalog);
        movieRental.setReturnDate(this.returnDate());
        movieRental.setReturnedDate(null);
        movieRental.setStatusRental(StatusRental.RENTED);
        return this.movieRentalRepository.save(movieRental);
    }

    @Transactional
    public MovieRental saveMovieRental(MovieRental movieRental) {
        return this.movieRentalRepository.save(movieRental);
    }

    private Date returnDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, DAYS_TO_RETURN);
        return calendar.getTime();
    }
}
