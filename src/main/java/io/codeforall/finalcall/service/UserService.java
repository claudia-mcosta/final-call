package io.codeforall.finalcall.service;

import io.codeforall.finalcall.exceptions.PassengerNotFoundException;
import io.codeforall.finalcall.exceptions.UserNotFoundException;
import io.codeforall.finalcall.persistence.model.Passenger;
import io.codeforall.finalcall.persistence.model.User;

import java.util.List;

public interface UserService {

    User get(Integer id);

    User save(User user);

    void delete(Integer id) throws UserNotFoundException;

    List<User> list();

    List<Passenger> listPassengers(User user);

    Passenger addPassenger(Integer id, Passenger passenger) throws UserNotFoundException;

    void deletePassenger(Integer id, Integer pid) throws UserNotFoundException, PassengerNotFoundException;
}
