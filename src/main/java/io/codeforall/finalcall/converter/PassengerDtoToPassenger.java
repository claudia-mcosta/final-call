package io.codeforall.finalcall.converter;

import io.codeforall.finalcall.command.PassengerDto;
import io.codeforall.finalcall.persistence.model.Passenger;
import io.codeforall.finalcall.persistence.model.User;
import io.codeforall.finalcall.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PassengerDtoToPassenger {

    private PassengerService passengerService;

    @Autowired
    public void setPassengerService(PassengerService passengerService) {
        this.passengerService = passengerService;
    }

    public Passenger convert(PassengerDto passengerDto) {

        Passenger passenger = (passengerDto.getId() != null ? passengerService.get(passengerDto.getId()) : new Passenger());

        if(passenger == null)
            passenger = new Passenger();

        passenger.setNationalId(passengerDto.getNationalId());
        passenger.setFirstName(passengerDto.getFirstName());
        passenger.setLastName(passengerDto.getLastName());
        passenger.setBirthdate(passengerDto.getBirthdate());
        passenger.setEmail(passengerDto.getEmail());
        passenger.setPhone(passengerDto.getPhone());

        return passenger;
    }
}
