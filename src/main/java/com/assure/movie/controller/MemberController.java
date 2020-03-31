package com.assure.movie.controller;

import com.assure.movie.common.converter.MemberConverter;
import com.assure.movie.dto.MemberDTO;
import com.assure.movie.model.domain.Member;
import com.assure.movie.service.MemberService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author Israel Yasis
 */
@RestController
@Api(tags = "Members")
public class MemberController extends ApiController {

    private MemberConverter memberConverter;

    private MemberService memberService;

    @Autowired
    public MemberController(
            MemberConverter memberConverter,
            MemberService memberService
    ) {
        this.memberConverter = memberConverter;
        this.memberService = memberService;
    }

    @RequestMapping(value = "/members", method = RequestMethod.POST)
    public ResponseEntity<MemberDTO> getMovie(@Valid @RequestBody MemberDTO memberDTO) {
        Member member = memberConverter.createFrom(memberDTO);
        this.memberService.saveMember(member);
        return new ResponseEntity<>(
                HttpStatus.CREATED
        );
    }

}
