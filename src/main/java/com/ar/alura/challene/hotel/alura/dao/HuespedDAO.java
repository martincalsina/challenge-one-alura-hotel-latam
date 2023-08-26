/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ar.alura.challene.hotel.alura.dao;

import com.ar.alura.challene.hotel.alura.model.Huesped;
import com.ar.alura.challene.hotel.alura.model.Reserva;
import com.ar.alura.challene.hotel.alura.utils.JPAUtils;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author marti
 */
public class HuespedDAO {
    
    private JPAUtils jpaUtils;
    
    public HuespedDAO() {
        this.jpaUtils = new JPAUtils();
    }
    
    public void guardar(Huesped huesped) {
        
        EntityManager em = jpaUtils.getEntityManager();
        
        em.getTransaction().begin();
        em.persist(huesped);
        em.getTransaction().commit();
        em.close();
    }
    
    public void eliminar(Huesped huesped) {
        
        EntityManager em = jpaUtils.getEntityManager();
        
        em.getTransaction().begin();
        huesped = em.merge(huesped);
        em.remove(huesped);
        em.getTransaction().commit();
        em.close();
    }
    
    public void eliminarPorId(Integer id) {
        
        Huesped huesped = this.buscarPorId(id);
        
        EntityManager em = jpaUtils.getEntityManager();
        em.getTransaction().begin();
        huesped = em.merge(huesped);
        List<Reserva> reservas = huesped.getReservas();
        for (Reserva reserva : reservas) {
            reserva = em.merge(reserva);
            em.remove(reserva);
        }
        em.remove(huesped);
        em.getTransaction().commit();
        em.close();
        
    }
    
    public void modificar(Huesped huesped) {
        
       Huesped huespedOriginal = this.buscarPorId(huesped.getId());
    
       EntityManager em = jpaUtils.getEntityManager();
       
       em.getTransaction().begin();
       huespedOriginal = em.merge(huespedOriginal);
       huespedOriginal.setNombre(huesped.getNombre());
       huespedOriginal.setApellido(huesped.getApellido());
       huespedOriginal.setFechaNacimiento(huesped.getFechaNacimiento());
       huespedOriginal.setNacionalidad(huesped.getNacionalidad());
       huespedOriginal.setTelefono(huesped.getTelefono());
       em.getTransaction().commit();
       em.close();
       
       
       
    }
    
    public Huesped traer(Huesped huesped) {
        
        EntityManager em = jpaUtils.getEntityManager();
        
        em.getTransaction().begin();
        huesped = em.merge(huesped);
        em.getTransaction().commit();
        em.close();
        
        return huesped;
    }
    
    public List<Huesped> traerTodos() {
        
        EntityManager em = jpaUtils.getEntityManager();
        
        em.getTransaction().begin();
        String jpql = "SELECT h FROM Huesped AS h";
        List<Huesped> huespedes = em.createQuery(jpql, Huesped.class).getResultList();
        em.close();
        
        return huespedes;
    }
    
    public Huesped buscarPorId(Integer id) {
        
        EntityManager em = jpaUtils.getEntityManager();
        
        em.getTransaction().begin();
        String jpql = "SELECT h FROM Huesped AS h WHERE h.id = :id";
        Huesped huesped = em.createQuery(jpql, Huesped.class).setParameter("id", id).getSingleResult();
        em.close();
        
        return huesped;
    }
    
    public List<Huesped> buscarPorApellido(String apellido) {
        
        EntityManager em = jpaUtils.getEntityManager();
        
        em.getTransaction().begin();
        String jpql = "SELECT h FROM Huesped AS h WHERE h.apellido LIKE :apellido";
        List<Huesped> huespedes = em.createQuery(jpql, Huesped.class).setParameter("apellido", "%"+apellido+"%").getResultList();
        em.close();
        
        return huespedes;
        
    }
    
    public Huesped buscarPorNumeroReserva(Integer numReserva) {
        
        EntityManager em = jpaUtils.getEntityManager();
        try {
            em.getTransaction().begin();
            String jpql = "SELECT h FROM Huesped AS h JOIN h.reservas AS r WHERE r.id = :id";
            Huesped huesped = em.createQuery(jpql, Huesped.class).setParameter("id", numReserva).getSingleResult();
            em.close();
            return huesped;
        } catch (Exception ex) {
            System.out.println("No se ha encontrado ningún huesped con la reserva indicada");
            System.out.println(ex.getMessage());
            System.out.println(ex.getStackTrace());
            return new Huesped();
        }

    }
    
    
    
}
