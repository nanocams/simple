/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projeto.lab.aid.familylocator.Entity.service;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;

/**
 *
 * @author Cams
 */
public abstract class AbstractFacade<T> {

    private Class<T> entityClass;

    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    protected abstract EntityManager getEntityManager();

    public void create(T entity) {
        getEntityManager().persist(entity);
    }

    public void edit(T entity) {
        getEntityManager().merge(entity);
    }

    public void remove(T entity) {
        getEntityManager().remove(getEntityManager().merge(entity));
    }

    public T find(Object id) {
        return getEntityManager().find(entityClass, id);
    }

    public List<T> findAll() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return getEntityManager().createQuery(cq).getResultList();
    }

    public List<T> findRange(int[] range) {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        q.setMaxResults(range[1] - range[0] + 1);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

    public int count() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
        cq.select(getEntityManager().getCriteriaBuilder().count(rt));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }
    
    
     
    public void Atualizar(T entity) {
        getEntityManager().refresh(entity);
    }
    
     public List<T> listarTodos(){
     javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
         CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
         cq.orderBy(cb.asc(rt.get("name")));
         cq.where(
         getEntityManager().getCriteriaBuilder().equal(rt.get("state"),1)
         );
        javax.persistence.Query q= getEntityManager().createQuery(cq);
        
        return q.getResultList();
     }
     
     
      public List<T> login(String u, String p){
      javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
         CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        // cq.orderBy(cb.asc(rt.get("name")));
        cq.where(
        getEntityManager().getCriteriaBuilder().equal(rt.get("state"),1),
        getEntityManager().getCriteriaBuilder().equal(rt.get("email"),u),
        getEntityManager().getCriteriaBuilder().equal(rt.get("password"),p)
         );
        javax.persistence.Query q= getEntityManager().createQuery(cq);
        
        return q.getResultList(); // q.setMaxResults(5).getResultList(); retorna max 5 linha
     }
     
      
        public List<T> procurarString(String nc, String v){
      javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
         CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        // cq.orderBy(cb.asc(rt.get("name")));
        cq.where(
       // getEntityManager().getCriteriaBuilder().equal(rt.get(nc),v)
       // getEntityManager().getCriteriaBuilder().like(rt.get(nc),v)  
                getEntityManager().getCriteriaBuilder().like(rt.get(nc),"%"+v+"%")  //
         );
        javax.persistence.Query q= getEntityManager().createQuery(cq);
        
        return q.getResultList(); // q.setMaxResults(5).getResultList(); retorna max 5 linha
     }
     
     
}
