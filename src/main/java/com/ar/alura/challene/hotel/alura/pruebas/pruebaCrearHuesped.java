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

        HuespedDAO huespedDao = new HuespedDAO();
        ReservaDAO reservaDao = new ReservaDAO();
        
        //creacion de Huesped
        Huesped huesped = new Huesped();
        
        String nombre = "Kenneth";
        String apellido = "Gerardo";
        
        huesped.setNombre(nombre);
        huesped.setApellido(apellido);
        
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        try {
            Date fechaNacimiento = formatter.parse("19-04-2005");
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
        //em.getTransaction().begin();
        huespedDao.guardar(huesped);
        
        //creacion de reservas
        
        Date fechaInicio = new Date();
        Date fechaFinal = new Date();
        
        try {
            fechaInicio = formatter.parse("29-06-2014");
            fechaFinal = formatter.parse("30-06-2014");
        } catch (ParseException ex) {
            System.out.println(ex.getMessage());
            ex.getStackTrace();
        }
        
        
        String formaDePago = "Efectivo";
        Reserva reserva1 = new Reserva(fechaInicio, fechaFinal, formaDePago, huesped);
        
        Date fechaInicio2 = new Date();
        Date fechaFinal2 = new Date();
        
        try {
            fechaInicio2 = formatter.parse("29-04-2014");
            fechaFinal2 = formatter.parse("30-06-2014");
        } catch (ParseException ex) {
            System.out.println(ex.getMessage());
            ex.getStackTrace();
        }
        
        String formaDePago2 = "Credito";
        Reserva reserva2 = new Reserva(fechaInicio2, fechaFinal2, formaDePago2, huesped);
        
        //guardado de las reservas en DB
        reservaDao.guardar(reserva1);
        reservaDao.guardar(reserva2);
        
        //agregado de las reservas a la lista de reservas
        reservas.add(reserva1);
        reservas.add(reserva2);
        
        //actualizacion de las reservas del huesped en DB
        Integer huespedId = huesped.getId();
        huesped.setReservas(reservas);
        huespedDao.modificar(huesped);
        //em.getTransaction().commit();
        //em.close();
        
        
        
        
    }   
    
}
