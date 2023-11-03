package org.codeforall.finalcall.persistence.dao.jpa;

import org.codeforall.finalcall.persistence.dao.Dao;

import javax.persistence.*;
import javax.persistence.criteria.*;
import java.util.List;

// TODO: Check if DAOs are only supposed to have basic operations or if they should have more in this case (i.e. Get only the next flight from a certain destination)

public abstract class GenericJpaDao<T, U> implements Dao<T, U> {

    protected Class<T> modelType;
    @PersistenceContext
    protected EntityManager em;

    public GenericJpaDao(Class<T> modelType) {
        this.modelType = modelType;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public List<T> findAll() {

        CriteriaQuery<T> criteriaQuery = em.getCriteriaBuilder().createQuery(modelType);
        Root<T> root = criteriaQuery.from(modelType);

        return em.createQuery(criteriaQuery).getResultList();

        // Using JPA
        // return em.createQuery( "from " + modelType.getSimpleName(), modelType).getResultList();
    }

    public T findById(U id) {
        return em.find(modelType, id);
    }

    public T saveOrUpdate(T modelObject) {
        return em.merge(modelObject);
    }

    public void delete(U id) {
        em.remove(em.find(modelType, id));
    }

}