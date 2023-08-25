/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ar.alura.challene.hotel.alura.controller;

import com.ar.alura.challene.hotel.alura.dao.ReservaDAO;
import com.ar.alura.challene.hotel.alura.model.Reserva;
import java.util.List;

/**
 *
 * @author marti
 */
public class ReservaController {
    
    private ReservaDAO reservaDao;
    
    public ReservaController() {
        this.reservaDao = new ReservaDAO();
    }
    
    public void guardar(Reserva reserva) {
        
        this.reservaDao.guardar(reserva);
        
    }
    
    public void eliminar(Reserva reserva) {
        
        this.reservaDao.eliminar(reserva);
        
    }
    
    public void eliminarPorId(Integer id) {
        
        this.reservaDao.eliminarPorId(id);
        
    }
    
    public void modificar(Reserva reserva) {
        
        this.reservaDao.modificar(reserva);
        
    }
    
    public Reserva traer(Reserva reserva) {
        
        return this.reservaDao.traer(reserva);
        
    }
    
    public List<Reserva> traerTodos() {
        
        return this.reservaDao.traerTodos();
        
    }
    
    public Reserva buscarPorNumero(Integer numReserva) {
        
        return this.reservaDao.buscarPorNumero(numReserva);
                
    }
    
    
    
}
