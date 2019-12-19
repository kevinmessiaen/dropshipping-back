package com.messiaen.dropshipping.service;

import com.messiaen.dropshipping.entity.Basket;
import com.messiaen.dropshipping.model.UserDto;

import java.util.Optional;

public interface IUserService {

    Optional<UserDto> findByUsername(String username);

    UserDto createUser(UserDto user);

}
