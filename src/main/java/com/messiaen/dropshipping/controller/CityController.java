package com.messiaen.dropshipping.controller;

import com.messiaen.dropshipping.model.CityDto;
import com.messiaen.dropshipping.service.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class CityController {

    private final ICityService cityService;

    @Autowired
    public CityController(ICityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping("/city/code/{postCode}")
    private ResponseEntity<Collection<CityDto>> startingWithPostCode(@PathVariable String postCode) {
        return ResponseEntity.ok(cityService.startingWithPostCode(postCode));
    }

}
