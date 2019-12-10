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
public class CategoryDto {

    private Short id;

    private String name;

    private String desc;

    private String path;

    private Short parent;

    private Collection<Short> children;

    private Integer level;

}
