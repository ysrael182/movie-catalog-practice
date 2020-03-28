package com.assure.movie.dto;

import com.assure.movie.model.domain.Movie;

import java.util.ArrayList;
import java.util.List;

public class BuilderMovieDTO implements BuilderDTO<MovieDTO> {

    private Movie movieModel;

    public BuilderMovieDTO setMovieModel(Movie movieModel) {
        this.movieModel = movieModel;
        return this;
    }
    @Override
    public MovieDTO build() {
        MovieDTO movieDTO = new MovieDTO();
        movieDTO.setTitle(this.movieModel.getTitle())
                .setRate(this.movieModel.getRate());
        if(this.movieModel.getActors().size() > 0) {
            List<ActorDTO> actorsDTO = new ArrayList<>();
            this.movieModel.getActors().forEach( actor -> {
                ActorDTO actorDTO = (new BuilderActorDTO()).setActorModel(actor).build();
                actorsDTO.add(actorDTO);
            });
            movieDTO.setActors(actorsDTO);
        }
        return movieDTO;
    }
}
