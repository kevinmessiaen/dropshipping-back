package com.messiaen.dropshipping.service;

import com.messiaen.dropshipping.model.ProductDto;

import java.util.Collection;

public interface IProductService {

    Collection<ProductDto> findAll();

}
