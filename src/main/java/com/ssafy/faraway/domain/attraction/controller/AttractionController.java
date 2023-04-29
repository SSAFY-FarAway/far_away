package com.ssafy.faraway.domain.attraction.controller;

import io.swagger.annotations.Api;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/attraction")
@Api(tags="attraction")
public class AttractionController {

    @RequestMapping("/")
    public ResponseEntity<Integer> test() {
        return new ResponseEntity<>(0, HttpStatus.OK);
    }
}
