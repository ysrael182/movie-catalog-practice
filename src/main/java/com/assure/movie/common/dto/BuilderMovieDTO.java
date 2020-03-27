package com.assure.movie.common.dto;

public class BuilderMovieDTO implements BuilderDTO<MovieDTO> {

    public MovieDTO build() {
        MovieDTO movieDTO = new MovieDTO();
        return movieDTO;
    }
}
