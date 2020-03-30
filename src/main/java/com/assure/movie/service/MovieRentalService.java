package com.assure.movie.service;

import com.assure.movie.common.enums.StatusRental;
import com.assure.movie.common.errors.NotFoundErrorException;
import com.assure.movie.model.domain.Member;
import com.assure.movie.model.domain.Movie;
import com.assure.movie.model.domain.MovieCatalog;
import com.assure.movie.model.domain.MovieRental;
import com.assure.movie.model.repository.MovieRentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Israel Yasis
 */
@Service
public class MovieRentalService {

    private MovieRentalRepository movieRentalRepository;
    private MovieService movieService;
    private MemberService memberService;

    @Autowired
    public MovieRentalService(
        MovieRentalRepository movieRentalRepository,
        MovieService movieService,
        MemberService memberService
    ) {
        this.memberService = memberService;
        this.movieService = movieService;
        this.movieRentalRepository = movieRentalRepository;
    }
    private MovieRental getMovieRental(Long id) throws NotFoundErrorException {
        return this.movieRentalRepository.findById(id).orElseThrow( ()
                -> new NotFoundErrorException("Not found movie rental with id: "+ id));
    }

    public MovieRental returnMovieRental(Long id, StatusRental statusRental) {
        MovieRental movieRental = this.getMovieRental(id);
        movieRental.setStatusRental(StatusRental.RETURNED);
        MovieCatalog movieCatalog = movieRental.getMovieCatalog();
        movieCatalog.setNumberCopies(movieCatalog.getNumberCopies()  + 1);
        movieRental.setMovieCatalog(movieCatalog);
        return this.saveMovieRental(movieRental);
    }
    public MovieRental createMovieRental(
        MovieRental movieRental,
        Long movieId,
        Long memberId
    ) throws NotFoundErrorException {
        Movie movie = this.movieService.getMovie(movieId);
        Member member = this.memberService.getMember(memberId);
        movieRental.setMember(member);
        movieRental.setMovieCatalog(movie.getMovieCatalog());
        return this.saveMovieRental(movieRental);
    }
    @Transactional
    public MovieRental saveMovieRental(MovieRental movieRental) {
        return this.movieRentalRepository.save(movieRental);
    }
}
