package com.messiaen.dropshipping.transformer;

import com.messiaen.dropshipping.entity.User;
import com.messiaen.dropshipping.model.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserTransformer extends Transformer<User, UserDto, Long> {

    private final PasswordEncoder encoder;

    @Autowired
    public UserTransformer(PasswordEncoder encoder) {
        this.encoder = encoder;
    }

    @Override
    public UserDto transformToDto(User entity) {
        return entity == null ? null :
                UserDto.builder()
                        .id(entity.getId())
                        .username(entity.getUsername())
                        .build();
    }

    @Override
    public Long extractKey(User entity) {
        return entity == null ? null : entity.getId();
    }

    @Override
    public User transformToEntity(UserDto dto) {
        return dto == null ? null :
                User.builder()
                        .id(dto.getId())
                        .username(dto.getUsername())
                        .password(encoder.encode(dto.getPassword()))
                        .build();
    }

    @Override
    public User holdKey(Long key) {
        return key == null ? null : User.builder().id(key).build();
    }
}
