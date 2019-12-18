package com.messiaen.dropshipping.service.impl;

import com.messiaen.dropshipping.entity.Basket;
import com.messiaen.dropshipping.entity.User;
import com.messiaen.dropshipping.model.UserDto;
import com.messiaen.dropshipping.repository.UserRepository;
import com.messiaen.dropshipping.service.IUserService;
import com.messiaen.dropshipping.transformer.UserTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements IUserService {

    private final UserRepository userRepository;
    private final UserTransformer userTransformer;

    @Autowired
    public UserService(UserRepository userRepository, UserTransformer userTransformer) {
        this.userRepository = userRepository;
        this.userTransformer = userTransformer;
    }

    @Override
    public Optional<UserDto> findByUsername(String username) {
        return userRepository.findByUsername(username).map(userTransformer::transformToDto);
    }

    @Override
    public UserDto createUser(UserDto dto) {
        return userTransformer.transformToDto(userRepository.save(userTransformer.transformToEntity(dto)));
    }
}
