package com.assure.movie.dto;
/**
 * @author Israel Yasis
 */
public class ActorDTO implements DTO {

    private Long actorId;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getActorId() {
        return actorId;
    }

    public void setActorId(Long actorId) {
        this.actorId = actorId;
    }
}
