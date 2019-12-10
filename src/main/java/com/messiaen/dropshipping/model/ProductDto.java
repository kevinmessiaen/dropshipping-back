package com.messiaen.dropshipping.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ProductDto {

    private Integer id;
    private String name;
    private String desc;
    private String path;
    private Double price;
    private Short categoryId;

}
