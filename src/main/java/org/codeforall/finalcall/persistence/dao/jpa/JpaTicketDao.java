package org.codeforall.finalcall.persistence.dao.jpa;

import org.codeforall.finalcall.persistence.model.Flight;
import org.codeforall.finalcall.persistence.model.Passenger;
import org.codeforall.finalcall.persistence.model.ticket.Ticket;
import org.codeforall.finalcall.persistence.model.ticket.TicketId;
import org.codeforall.finalcall.persistence.dao.TicketDao;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.*;
import java.util.List;

// TODO: Check if TicketDao's find and delete methods should have Passenger and Flight as arguments instead of the IdClass TicketId. Ticket has composite key, therefore the id is not a String like the other models. This is working as is though.

@Repository
public class JpaTicketDao extends GenericJpaDao<Ticket, TicketId> implements TicketDao {

    public JpaTicketDao() {
        super(Ticket.class);
    }


    @Override
    public Ticket findByFlightAndPassenger(Flight flight, Passenger passenger) {

        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Ticket> criteriaQuery = criteriaBuilder.createQuery(modelType);

        Root<Ticket> root = criteriaQuery.from(modelType);
        criteriaQuery.where(criteriaBuilder.equal(root.get("flight"), flight),
                            criteriaBuilder.equal(root.get("passenger"), passenger));

        return em.createQuery(criteriaQuery).getSingleResult();
    }

    @Override
    public List<Ticket> findByFlight(Flight flight) {

        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Ticket> criteriaQuery = criteriaBuilder.createQuery(modelType);

        Root<Ticket> root = criteriaQuery.from(modelType);
        criteriaQuery.where(criteriaBuilder.equal(root.get("flight"), flight));

        return em.createQuery(criteriaQuery).getResultList();

    }

    @Override
    public List<Ticket> findByPassenger(Passenger passenger) {

        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Ticket> criteriaQuery = criteriaBuilder.createQuery(modelType);

        Root<Ticket> root = criteriaQuery.from(modelType);
        criteriaQuery.where(criteriaBuilder.equal(root.get("passenger"), passenger));

        return em.createQuery(criteriaQuery).getResultList();

    }
}