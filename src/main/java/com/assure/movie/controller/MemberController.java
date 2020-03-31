package com.assure.movie.controller;

import com.assure.movie.common.converter.MemberConverter;
import com.assure.movie.common.response.CreatedResponse;
import com.assure.movie.dto.MemberDTO;
import com.assure.movie.model.domain.Member;
import com.assure.movie.service.MemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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

    @RequestMapping(value = "/members", method = RequestMethod.GET)
    public ResponseEntity<List<MemberDTO>> getMembers() {
        List<Member> members = this.memberService.getMembers();
        List<MemberDTO> memberDTO = memberConverter.createFromEntities(members);
        return new ResponseEntity<>(
                memberDTO,
                HttpStatus.OK
        );
    }

    @RequestMapping(value = "/members", method = RequestMethod.POST)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ok", response = MemberDTO.class),
            @ApiResponse(code = 201, message = "Created", response = CreatedResponse.class)
    })
    public ResponseEntity<CreatedResponse> getMember(@Valid @RequestBody MemberDTO memberDTO) {
        Member member = memberConverter.createFrom(memberDTO);
        member = this.memberService.saveMember(member);
        return new ResponseEntity<>(
                (new CreatedResponse(HttpStatus.CREATED.toString(), member.getId())),
                HttpStatus.CREATED
        );
    }

}
