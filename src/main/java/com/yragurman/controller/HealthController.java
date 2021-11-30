package com.yragurman.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {
    @RequestMapping(value = "/healthcheck", method = RequestMethod.GET)
    public ResponseEntity returnHealthCheckResponse() {
        return new ResponseEntity<>("http status = 200", HttpStatus.OK);
    }
}
