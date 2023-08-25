/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ar.alura.challene.hotel.alura.controller;

import com.ar.alura.challene.hotel.alura.dao.HuespedDAO;
import com.ar.alura.challene.hotel.alura.model.Huesped;
import java.util.List;

/**
 *
 * @author marti
 */
public class HuespedController {
    
    private HuespedDAO huespedDao;
    
    public HuespedController() {
        this.huespedDao = new HuespedDAO();
    }
    
    public void guardar(Huesped huesped) {
        
        this.huespedDao.guardar(huesped);
        
    }
    
    public void eliminar(Huesped huesped) {
        
        this.huespedDao.eliminar(huesped);
        
    }
    
    public void eliminarPorId(Integer id) {
        
        this.huespedDao.eliminarPorId(id);
        
    }
    
    public void modificar(Integer idHuesped, Huesped huespedEditado) {
        
       this.huespedDao.modificar(idHuesped, huespedEditado);
       
    }
    
    public Huesped traer(Huesped huesped) {
        
        return this.huespedDao.traer(huesped);
    }
    
    public List<Huesped> traerTodos() {
        
        return this.huespedDao.traerTodos();
        
    }
    
    public Huesped buscarPorId(Integer id) {
        
        return this.huespedDao.buscarPorId(id);
        
    }
    
    public List<Huesped> buscarPorApellido(String apellido) {
        
        return this.huespedDao.buscarPorApellido(apellido);
        
    }
    
    public Huesped buscarPorNumeroReserva(Integer numReserva) {
        
        return this.huespedDao.buscarPorNumeroReserva(numReserva);
        
    }
    
    
}
