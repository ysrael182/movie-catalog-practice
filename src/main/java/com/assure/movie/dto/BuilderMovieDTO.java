package com.assure.movie.dto;

import com.assure.movie.common.enums.Rate;
import com.assure.movie.model.domain.Actor;
import com.assure.movie.model.domain.Movie;

import java.util.ArrayList;
import java.util.List;
@Deprecated
public class BuilderMovieDTO implements BuilderDTO<MovieDTO> {

    private String title;
    private Rate rate;
    private List<Actor> actors;
    public BuilderMovieDTO setTitle(String title) {
        this.title = title;
        return this;
    }
    public BuilderMovieDTO setRate(Rate rate) {
        this.rate = rate;
        return this;
    }
    public BuilderMovieDTO setActor(List<Actor> actors) {
        this.actors = actors;
        return this;
    }
    @Override
    public MovieDTO build() {
        MovieDTO movieDTO = new MovieDTO();
        movieDTO.setTitle(this.title).setRate(this.rate);
        if(this.actors.size() > 0) {
            /*List<ActorDTO> actorsDTO = new ArrayList<>();
            this.movieModel.getActors().forEach( actor -> {
                ActorDTO actorDTO = (new BuilderActorDTO()).setActorModel(actor).build();
                actorsDTO.add(actorDTO);
            });
            movieDTO.setActors(actorsDTO);*/
        }
        return movieDTO;
    }
}
