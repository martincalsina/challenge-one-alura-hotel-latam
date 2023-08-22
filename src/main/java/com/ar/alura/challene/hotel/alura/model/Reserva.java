/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ar.alura.challene.hotel.alura.model;

import com.ar.alura.challene.hotel.alura.utils.CalculadoraDePrecioUtils;
import java.math.BigDecimal;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author marti
 */
@Entity
@Table(name="reserva")
public class Reserva {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="fecha_entrada")
    private LocalDate fechaEntrada;
    @Column(name="fecha_salida")
    private LocalDate fechaSalida;
    private BigDecimal precio; 
    @Column(name="forma_de_pago")
    private String formaDePago;
    
    @ManyToOne()
    private Huesped huesped;
    
    public Reserva(LocalDate fechaEntrada, LocalDate fechaSalida, String formaDePago) {
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.formaDePago = formaDePago;
        this.precio = new CalculadoraDePrecioUtils().calcularPrecio(fechaEntrada, fechaSalida, formaDePago);
    }

    public Reserva(LocalDate fechaEntrada, LocalDate fechaSalida, String formaDePago, Huesped huesped) {
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.formaDePago = formaDePago;
        this.precio = new CalculadoraDePrecioUtils().calcularPrecio(fechaEntrada, fechaSalida, formaDePago);
        this.huesped = huesped;
    }  

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(LocalDate fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public LocalDate getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(LocalDate fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public String getFormaDePago() {
        return formaDePago;
    }

    public void setFormaDePago(String formaDePago) {
        this.formaDePago = formaDePago;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }
    
    
    
    
}
