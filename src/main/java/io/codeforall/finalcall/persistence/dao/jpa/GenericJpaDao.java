package io.codeforall.finalcall.persistence.dao.jpa;

import io.codeforall.finalcall.persistence.dao.Dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
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

    @Override
    public List<T> findAll() {

        CriteriaQuery<T> criteriaQuery = em.getCriteriaBuilder().createQuery(modelType);
        Root<T> root = criteriaQuery.from(modelType);

        return em.createQuery(criteriaQuery).getResultList();

        // Using JPA
        // return em.createQuery( "from " + modelType.getSimpleName(), modelType).getResultList();
    }

    @Override
    public T findById(U id) {
        // return em.createQuery("SELECT u FROM " + modelType.getSimpleName() + " AS u JOIN FETCH u.passengers WHERE u.id=:id", modelType).setParameter("id", id).getSingleResult();
        return em.find(modelType, id);
    }

    @Override
    public T saveOrUpdate(T modelObject) {
        return em.merge(modelObject);
    }

    @Override
    public void delete(U id) {
        em.remove(em.find(modelType, id));
    }
}