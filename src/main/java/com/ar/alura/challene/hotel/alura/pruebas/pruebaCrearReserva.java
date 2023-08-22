/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ar.alura.challene.hotel.alura.pruebas;

import com.ar.alura.challene.hotel.alura.dao.ReservaDAO;
import com.ar.alura.challene.hotel.alura.model.Reserva;
import com.ar.alura.challene.hotel.alura.utils.JPAUtils;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.swing.text.DateFormatter;

/**
 *
 * @author marti
 */
public class pruebaCrearReserva {
    
    public static void main(String[] args) {

        ReservaDAO reservaDao = new ReservaDAO();
        
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        
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
        Reserva reserva = new Reserva(fechaInicio, fechaFinal, formaDePago);
        
        reservaDao.guardar(reserva);
        
        System.out.println("Reserva guardada");
    }
    
}
