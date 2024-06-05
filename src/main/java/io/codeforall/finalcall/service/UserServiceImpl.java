package io.codeforall.finalcall.service;

import io.codeforall.finalcall.exceptions.PassengerNotFoundException;
import io.codeforall.finalcall.exceptions.UserNotFoundException;
import io.codeforall.finalcall.persistence.dao.PassengerDao;
import io.codeforall.finalcall.persistence.dao.UserDao;
import io.codeforall.finalcall.persistence.model.Booking;
import io.codeforall.finalcall.persistence.model.Passenger;
import io.codeforall.finalcall.persistence.model.User;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    private UserDao userDao;
    private PassengerDao passengerDao;

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Autowired
    public void setPassengerDao(PassengerDao passengerDao) {
        this.passengerDao = passengerDao;
    }

    @Override
    public User get(Integer id) {
        return userDao.findById(id);
    }

    @Transactional
    @Override
    public User save(User user) {
        return userDao.saveOrUpdate(user);
    }

    @Transactional
    @Override
    public void delete(Integer id) throws UserNotFoundException {

        Optional.ofNullable(userDao.findById(id))
                .orElseThrow(UserNotFoundException::new);

        userDao.delete(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> list() {
        return userDao.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public List<Passenger> listPassengers(User user) {
        return user.getPassengers();
    }

    @Transactional
    @Override
    public Passenger addPassenger(Integer id, Passenger passenger) throws UserNotFoundException {

        User user = Optional.ofNullable(userDao.findById(id))
                .orElseThrow(UserNotFoundException::new);

        user.addPassenger(passenger);
        userDao.saveOrUpdate(user);

        return user.getPassengers().get(user.getPassengers().size() - 1);
    }

    @Transactional
    @Override
    public void deletePassenger(Integer id, Integer pid) throws UserNotFoundException, PassengerNotFoundException {

        User user = Optional.ofNullable(userDao.findById(id))
                .orElseThrow(UserNotFoundException::new);

        Passenger passenger = Optional.ofNullable(passengerDao.findById(pid))
                .orElseThrow(PassengerNotFoundException::new);

        if (!passenger.getUser().getId().equals(id)) {
            throw new PassengerNotFoundException();
        }

        user.removePassenger(passenger);
        userDao.saveOrUpdate(user);
    }

    @Transactional
    @Override
    public Booking addBooking(Integer id, Booking booking) throws UserNotFoundException {


        User user = Optional.ofNullable(userDao.findById(id))
                    .orElseThrow(UserNotFoundException::new);

        user.addBooking(booking);
        userDao.saveOrUpdate(user);

        return user.getBookings().get(user.getBookings().size() - 1);
    }
}