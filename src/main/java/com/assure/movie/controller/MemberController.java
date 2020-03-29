package com.assure.movie.controller;

import com.assure.movie.dto.MemberDTO;
import com.assure.movie.dto.MovieDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author Israel Yasis
 */
@RestController
public class MemberController {


    @RequestMapping(value = "/members", method = RequestMethod.POST)
    public ResponseEntity<MovieDTO> getMovie(@Valid @RequestBody MemberDTO memberDTO) {
        return null;
    }

}
