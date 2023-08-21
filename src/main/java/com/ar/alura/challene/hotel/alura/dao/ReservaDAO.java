/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ar.alura.challene.hotel.alura.dao;

import com.ar.alura.challene.hotel.alura.model.Reserva;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author marti
 */
public class ReservaDAO {
    
    private EntityManager em;
    
    public ReservaDAO(EntityManager em) {
        this.em = em;
    }
    
    public void guardar(Reserva reserva) {
        em.persist(reserva);
    }
    
    public void eliminar(Reserva reserva) {
        reserva = em.merge(reserva);
        em.remove(reserva);
    }
    
    public Reserva traer(Reserva reserva) {
        return em.merge(reserva);
    }
    
    public List<Reserva> traerTodos() {
        String jpql = "SELECT r FROM reserva AS r";
        return em.createQuery(jpql, Reserva.class).getResultList();
    }
    
    public Reserva buscarPorNumero(Integer numReserva) {
        String jpql = "SELECT r FROM reserva AS r WHERE reserva.id = :id";
        return em.createQuery(jpql, Reserva.class).setParameter("id", numReserva).getSingleResult();
    }
    
}
