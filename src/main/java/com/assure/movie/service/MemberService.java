package com.assure.movie.service;

import com.assure.movie.model.domain.Member;
import com.assure.movie.model.repository.MemberRepository;
import com.assure.movie.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * @author Israel Yasis
 */
@Service
public class MemberService {

    private MemberRepository memberRepository;
    private UserRepository userRepository;

    @Autowired
    public MemberService(
        MemberRepository memberRepository,
        UserRepository userRepository
    ) {
        this.userRepository = userRepository;
        this.memberRepository = memberRepository;
    }


    @Transactional
    public Member saveMember(Member member) {
        return this.memberRepository.save(member);
    }
}
