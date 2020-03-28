package com.assure.movie.dto;

import com.assure.movie.model.domain.Actor;

public class BuilderActorDTO implements BuilderDTO<ActorDTO> {

    private Actor actorModel;

    public BuilderActorDTO setActorModel(Actor actorModel) {
        this.actorModel = actorModel;
        return this;
    }
    @Override
    public ActorDTO build() {
        ActorDTO actorDTO = new ActorDTO();
        actorDTO.setName(this.actorModel.getName());
        return actorDTO;
    }
}
