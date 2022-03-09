package com.springboot.tutorial.controller;

import com.springboot.tutorial.properties.ApplicationProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/properties")
@RequiredArgsConstructor
public class PropertiesController {

    private final ApplicationProperties applicationProperties;

    @GetMapping(path = "/application", produces = MediaType.APPLICATION_JSON_VALUE)
    private String getApplicationProperties() {
        return applicationProperties.toString();
    }

}
