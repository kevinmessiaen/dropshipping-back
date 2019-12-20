package com.messiaen.dropshipping.service.impl;

import com.messiaen.dropshipping.model.CityDto;
import com.messiaen.dropshipping.repository.CityRepository;
import com.messiaen.dropshipping.service.ICityService;
import com.messiaen.dropshipping.transformer.entity.CityTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class CityService implements ICityService {

    private final CityRepository cityRepository;
    private final CityTransformer cityTransformer;

    @Autowired
    public CityService(CityRepository cityRepository, CityTransformer cityTransformer) {
        this.cityRepository = cityRepository;
        this.cityTransformer = cityTransformer;
    }

    @Override
    public Collection<CityDto> startingWithPostCode(String code) {
        return cityTransformer.transformToDto(cityRepository.findAllByPostCodeStartingWith(code));
    }

}
