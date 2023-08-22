/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ar.alura.challene.hotel.alura.pruebas;

import com.ar.alura.challene.hotel.alura.dao.HuespedDAO;
import com.ar.alura.challene.hotel.alura.dao.ReservaDAO;
import com.ar.alura.challene.hotel.alura.model.Huesped;
import com.ar.alura.challene.hotel.alura.model.Reserva;
import com.ar.alura.challene.hotel.alura.utils.JPAUtils;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;

/**
 *
 * @author marti
 */
public class pruebaCrearHuesped {
    
    public static void main(String[] args) {
        
        EntityManager em = new JPAUtils().getEntityManager();
        HuespedDAO huespedDao = new HuespedDAO(em);
        ReservaDAO reservaDao = new ReservaDAO(em);
        
        //creacion de Huesped
        Huesped huesped = new Huesped();
        
        String nombre = "Kenneth";
        String apellido = "Gerardo";
        
        huesped.setNombre(nombre);
        huesped.setApellido(apellido);
        
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        try {
            Date fechaNacimiento = formatter.parse("19-03-2005");
            huesped.setFechaNacimiento(fechaNacimiento);
        } catch (ParseException ex) {
            System.out.println(ex.getMessage());
            ex.getStackTrace();
        }
        
        String nacionalidad = "Brasileiro";
        String telefono = "123748012";
        
        huesped.setNacionalidad(nacionalidad);
        huesped.setTelefono(telefono);
        
        ArrayList<Reserva> reservas = new ArrayList<Reserva>();
        huesped.setReservas(reservas);
        
        //huesped.setId(1); NO VA CUANDO HAY GENERATEDVALUES
        
        //guardado de Huesped en DB
        em.getTransaction().begin();
        huespedDao.guardar(huesped);
        
        //creacion de reservas
        LocalDate fechaInicio = LocalDate.of(2014, 6, 29);
        LocalDate fechaFinal = LocalDate.of(2014, 6, 30);
        String formaDePago = "Efectivo";
        Reserva reserva1 = new Reserva(fechaInicio, fechaFinal, formaDePago, huesped);
        
        LocalDate fechaInicio2 = LocalDate.of(2014, 4, 29);
        LocalDate fechaFinal2 = LocalDate.of(2014, 6, 30);
        String formaDePago2 = "Credito";
        Reserva reserva2 = new Reserva(fechaInicio2, fechaFinal2, formaDePago2, huesped);
        
        //guardado de las reservas en DB
        reservaDao.guardar(reserva1);
        reservaDao.guardar(reserva2);
        
        //agregado de las reservas a la lista de reservas
        reservas.add(reserva1);
        reservas.add(reserva2);
        
        //actualizacion de las reservas del huesped en DB
        huesped = huespedDao.traer(huesped);
        huesped.setReservas(reservas);
        em.getTransaction().commit();
        em.close();
        
        
        
        
    }   
    
}
