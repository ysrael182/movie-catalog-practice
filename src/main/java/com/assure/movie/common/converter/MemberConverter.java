package com.assure.movie.common.converter;

import com.assure.movie.dto.MemberDTO;
import com.assure.movie.model.domain.Member;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope
public class MemberConverter implements GenericConverter<Member, MemberDTO> {

    @Override
    public Member createFrom(final MemberDTO dto) {
        return updateEntity(new Member(), dto);
    }

    @Override
    public MemberDTO createFrom(final Member entity) {
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setUserName(entity.getUserName());
        memberDTO.setName(entity.getName());
        memberDTO.setTelephone(entity.getTelephone());
        memberDTO.setId(entity.getId());
        return memberDTO;
    }
    @Override
    public Member updateEntity(final Member entity,
                                final MemberDTO dto) {
        entity.setUserName(dto.getUserName());
        entity.setName(dto.getName());
        entity.setTelephone(dto.getTelephone());
        //entity.setUser(dto.get);
        return entity;
    }
}
