package io.codeforall.finalcall.converter;

import io.codeforall.finalcall.command.PassengerDto;
import io.codeforall.finalcall.persistence.model.Passenger;
import org.springframework.stereotype.Component;

@Component
public class PassengerToPassengerDto {

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
