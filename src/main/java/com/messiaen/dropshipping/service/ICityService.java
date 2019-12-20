package com.messiaen.dropshipping.service;

import com.messiaen.dropshipping.model.CityDto;

import java.util.Collection;

public interface ICityService {

    Collection<CityDto> startingWithPostCode(String code);

}
