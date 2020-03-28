package com.assure.movie.dto.domain;

import com.assure.movie.dto.MovieDTO;
import com.assure.movie.model.domain.Movie;

public class BuilderMovieModel implements BuilderModel<Movie> {

    private MovieDTO movieDTO;

    private Movie movieModel;

    public BuilderMovieModel setMovieDTO(MovieDTO movieDTO) {
        this.movieDTO = movieDTO;
        return this;
    }
    public BuilderMovieModel setMovieModel(Movie movieModel) {
        this.movieModel = movieModel;
        return this;
    }
    @Override
    public Movie build() {
        if(this.movieModel == null) {
            this.movieModel = new Movie();
        }
        movieModel.setTitle(this.movieDTO.getTitle());
        movieModel.setRate(this.movieDTO.getRate());
        return movieModel;
    }
}
