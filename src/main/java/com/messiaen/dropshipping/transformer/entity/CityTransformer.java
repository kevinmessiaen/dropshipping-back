package com.messiaen.dropshipping.transformer.entity;

import com.messiaen.dropshipping.entity.City;
import com.messiaen.dropshipping.model.CityDto;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class CityTransformer extends Transformer<City, CityDto, Integer> {

    @Override
    public CityDto transformToDto(City entity) {
        return entity == null ? null :
                CityDto.builder()
                        .id(entity.getId())
                        .name(entity.getName())
                        .codes(Arrays.asList(entity.getPostCodes().split("-")))
                        .build();
    }

    @Override
    public Integer extractKey(City entity) {
        return entity == null ? null : entity.getId();
    }

    @Override
    public City transformToEntity(CityDto dto) {
        return dto == null ? null :
                City.builder()
                        .id(dto.getId())
                        .name(dto.getName())
                        .postCodes(String.join("-", dto.getCodes()))
                        .build();
    }

    @Override
    public City holdKey(Integer key) {
        return key == null ? null : City.builder().id(key).build();
    }
}
