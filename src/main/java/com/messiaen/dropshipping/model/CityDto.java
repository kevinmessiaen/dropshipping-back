package com.messiaen.dropshipping.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.Collection;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class CityDto {

    private Integer id;

    private String name;

    private Collection<String> codes;

}
