package io.codeforall.finalcall.converter;

import io.codeforall.finalcall.command.UserDto;
import io.codeforall.finalcall.persistence.model.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserToUserDto {

    public List<UserDto> convert(List<User> users) {

        return users.stream()
                .map(this::convert)
                .collect(Collectors.toList());
    }

    public UserDto convert(User user) {

        UserDto userDto = new UserDto();

        userDto.setId(user.getId());
        userDto.setEmail(user.getEmail());
        userDto.setPasswordHash(user.getPasswordHash());

        return userDto;
    }
}
