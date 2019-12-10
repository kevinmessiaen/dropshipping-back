package com.messiaen.dropshipping.service;

import com.messiaen.dropshipping.model.CategoryDto;

import java.util.Collection;

public interface ICategoryService {

    Collection<CategoryDto> findAll();

}
