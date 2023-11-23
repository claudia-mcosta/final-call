package io.codeforall.finalcall.command;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class AirportDto {

    @NotNull(message = "Origin airport IATA is mandatory.")
    @Size(min = 3, max = 3, message = "Origin airport IATA should have 3 characters.")
    private String code;
    @NotNull(message = "Name is mandatory.")
    @NotBlank(message = "Name is mandatory.")
    private String name;
    @NotNull(message = "City is mandatory.")
    @NotBlank(message = "City is mandatory.")
    private String city;
    @NotNull(message = "Country is mandatory.")
    @NotBlank(message = "Country is mandatory.")
    private String country;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "AirportDto{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
