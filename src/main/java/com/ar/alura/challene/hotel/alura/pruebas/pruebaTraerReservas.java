/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ar.alura.challene.hotel.alura.pruebas;

import com.ar.alura.challene.hotel.alura.dao.ReservaDAO;
import com.ar.alura.challene.hotel.alura.model.Reserva;
import com.ar.alura.challene.hotel.alura.utils.JPAUtils;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author marti
 */
public class pruebaTraerReservas {
    
    public static void main(String[] args) {

        ReservaDAO reservaDao = new ReservaDAO();
        
        List<Reserva> reservas = reservaDao.traerTodos();
        
        for (Reserva reserva : reservas) {
            System.out.println("Reserva numero: " + reserva.getId());
        }
        
        Reserva reservaIndividual = reservaDao.buscarPorNumero(2);
        System.out.println("Se trajo de forma individual la reserva de id : " + reservaIndividual.getId());
        
        
    }
    
}
