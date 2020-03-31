package com.assure.movie.common.converter;

import com.assure.movie.dto.ActorDTO;
import com.assure.movie.model.domain.Actor;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;
/**
 * @author Israel Yasis
 */
@Component
@RequestScope
public class ActorConverter implements GenericConverter<Actor, ActorDTO> {

    @Override
    public Actor createFrom(final ActorDTO dto) {
        return updateEntity(new Actor(), dto);
    }

    @Override
    public ActorDTO createFrom(final Actor entity) {
        ActorDTO actorDTO = new ActorDTO();
        actorDTO.setName(entity.getName());
        actorDTO.setActorId(entity.getId());
        return actorDTO;
    }
    @Override
    public Actor updateEntity(final Actor entity,
                                final ActorDTO dto) {
        entity.setId(dto.getActorId());
        entity.setName(dto.getName());
        return entity;
    }
}
