package io.codeforall.finalcall.converter;

import io.codeforall.finalcall.command.UserDto;
import io.codeforall.finalcall.persistence.model.User;
import io.codeforall.finalcall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserDtoToUser {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public User convert(UserDto userDto) {

        User user = (userDto.getId() != null ? userService.get(userDto.getId()) : new User());

        user.setEmail(userDto.getEmail());
        user.setPasswordHash(userDto.getPasswordHash());

        return user;
    }
}
