package io.codeforall.finalcall.converter;

import io.codeforall.finalcall.command.AirportDto;
import io.codeforall.finalcall.command.PassengerDto;
import io.codeforall.finalcall.persistence.model.Airport;
import io.codeforall.finalcall.persistence.model.Passenger;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PassengerToPassengerDto {

    public List<PassengerDto> convert(List<Passenger> passengers) {

        return passengers.stream()
                .map(this::convert)
                .collect(Collectors.toList());
    }

    public PassengerDto convert(Passenger passenger) {

        PassengerDto passengerDto = new PassengerDto();

        passengerDto.setNationalId(passenger.getNationalId());
        passengerDto.setFirstName(passenger.getFirstName());
        passengerDto.setLastName(passenger.getLastName());
        passengerDto.setBirthdate(passenger.getBirthdate());
        passengerDto.setPhone(passenger.getPhone());
        passengerDto.setEmail(passenger.getEmail());

        return passengerDto;
    }
}
