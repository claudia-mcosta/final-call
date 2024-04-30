package io.codeforall.finalcall.command;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class UserDto {

    private Integer id;

    @NotNull(message = "E-mail is mandatory.")
    @NotBlank(message = "E-mail is mandatory.")
    private String email;

    @NotNull(message = "Password is mandatory.")
    @NotBlank(message = "Password is mandatory.")
    private String passwordHash;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "id='" + id + '\'' +
                "email='" + email + '\'' +
                ", passwordHash='" + passwordHash + '\'' +
                '}';
    }
}
