/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ar.alura.challene.hotel.alura.dao;

import com.ar.alura.challene.hotel.alura.model.Huesped;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author marti
 */
public class HuespedDAO {
    
    private EntityManager em;
    
    public HuespedDAO(EntityManager em) {
        this.em = em;
    }
    
    public void guardar(Huesped huesped) {
        em.persist(huesped);
    }
    
    public void eliminar(Huesped huesped) {
        huesped = em.merge(huesped);
        em.remove(huesped);
    }
    
    public Huesped traer(Huesped huesped) {
        return em.merge(huesped);
    }
    
    public List<Huesped> traerTodos(Huesped huesped) {
        String jpql = "SELECT h FROM huesped AS h";
        return em.createQuery(jpql, Huesped.class).getResultList();
    }
    
    public List<Huesped> buscarPorApellido(String apellido) {
        String jpql = "SELECT h FROM huesped AS h WHERE h.apellido LIKE :apellido";
        return em.createQuery(jpql, Huesped.class).setParameter("apellido", "%"+apellido+"%").getResultList();
    }
    
    public Huesped buscarPorNumeroReserva(Integer numReserva) {
        String jpql = "SELECT h FROM huesped AS h JOIN h.reservas AS r WHERE r.id = :id";
        return em.createQuery(jpql, Huesped.class).setParameter("id", numReserva).getSingleResult();
    }
    
    
    
}
