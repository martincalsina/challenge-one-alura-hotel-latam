/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ar.alura.challene.hotel.alura.dao;

import com.ar.alura.challene.hotel.alura.model.Reserva;
import com.ar.alura.challene.hotel.alura.utils.JPAUtils;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author marti
 */
public class ReservaDAO {
    
    private JPAUtils jpaUtils;
    
    public ReservaDAO() {
        this.jpaUtils = new JPAUtils();
    }
    
    public void guardar(Reserva reserva) {
        
        EntityManager em = jpaUtils.getEntityManager();
        
        em.getTransaction().begin();
        em.persist(reserva);
        em.getTransaction().commit();
        em.close();
    }
    
    public void eliminar(Reserva reserva) {
        
        EntityManager em = jpaUtils.getEntityManager();
        
        em.getTransaction().begin();
        reserva = em.merge(reserva);
        em.remove(reserva);
        em.getTransaction().commit();
        em.close();
    }
    
    public Reserva traer(Reserva reserva) {
        
        EntityManager em = jpaUtils.getEntityManager();
        
        em.getTransaction().begin();
        reserva = em.merge(reserva);
        em.getTransaction().commit();
        em.close();
        return reserva;
    }
    
    public List<Reserva> traerTodos() {
        
        EntityManager em = jpaUtils.getEntityManager();
        
        em.getTransaction().begin();
        String jpql = "SELECT r FROM Reserva AS r";
        List<Reserva> reservas = em.createQuery(jpql, Reserva.class).getResultList();
        em.close();
        
        return reservas;
    }
    
    public Reserva buscarPorNumero(Integer numReserva) {
        
        EntityManager em = jpaUtils.getEntityManager();
        
        em.getTransaction().begin();
        String jpql = "SELECT r FROM Reserva AS r WHERE r.id = :id";
        Reserva reserva =  em.createQuery(jpql, Reserva.class).setParameter("id", numReserva).getSingleResult();
        em.close();
        
        return reserva;
    }
    
}
