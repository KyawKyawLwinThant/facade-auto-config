package com.demo.facade;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public abstract  class AbstractFacade<T> {
    private Class<T> entityClass;
    @PersistenceContext
    private EntityManager em;
    public AbstractFacade(Class<T> domainClass){
        this.entityClass =domainClass;
    }
    @Transactional
    public void create(T t){
        em.persist(t);
    }
    @Transactional
    public void edit(T t){
        em.merge(t);
    }
    @Transactional
    public void remove(T t){
        em.remove(em.merge(t));
    }
    public T find(Object id){
        return em.find(entityClass,id);
    }
    public List<T> findAll(){
        CriteriaQuery<T> criteriaQuery=em.getCriteriaBuilder().createQuery(entityClass);
        criteriaQuery.select(criteriaQuery.from(entityClass));
        return em.createQuery(criteriaQuery).getResultList();
    }
    public int count(){
        CriteriaQuery criteriaQuery=em.getCriteriaBuilder().createQuery();
        Root<T> root=criteriaQuery.from(entityClass);
        criteriaQuery.select(em.getCriteriaBuilder().count(root));
        Query query=em.createQuery(criteriaQuery);
        return ((Long)query.getSingleResult()).intValue();
    }
}
