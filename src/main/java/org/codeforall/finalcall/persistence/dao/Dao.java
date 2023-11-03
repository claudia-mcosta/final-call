package org.codeforall.finalcall.persistence.dao;

import java.util.List;

// TODO: Check if this ok or if U should be replaced with String and Ticket Dao doesn't implement this interface. Ticket has composite key, therefore the id is not a String like the other models.

public interface Dao<T, U> {

    List<T> findAll();

    T findById(U id);

    T saveOrUpdate(T modelObject);

    void delete(U id);
}