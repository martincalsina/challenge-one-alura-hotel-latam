/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ar.alura.challene.hotel.alura.model;

import com.ar.alura.challene.hotel.alura.utils.CalculadoraDePrecioUtils;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
    @Temporal(TemporalType.DATE)
    private Date fechaEntrada;
    @Column(name="fecha_salida")
    @Temporal(TemporalType.DATE)
    private Date fechaSalida;
    private BigDecimal precio; 
    @Column(name="forma_de_pago")
    private String formaDePago;
    
    @ManyToOne()
    private Huesped huesped;
    
    public Reserva() {
    }
    
    public Reserva(Date fechaEntrada, Date fechaSalida, String formaDePago) {
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.formaDePago = formaDePago;
        this.precio = new CalculadoraDePrecioUtils().calcularPrecio(fechaEntrada, fechaSalida, formaDePago);
    }

    public Reserva(Date fechaEntrada, Date fechaSalida, String formaDePago, Huesped huesped) {
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.formaDePago = formaDePago;
        this.precio = new CalculadoraDePrecioUtils().calcularPrecio(fechaEntrada, fechaSalida, formaDePago);
        this.huesped = huesped;
    }
    
    public Reserva(Integer id, Date fechaEntrada, Date fechaSalida, BigDecimal precio, String formaDePago) {
        this.id = id;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.precio = precio;
        this.formaDePago = formaDePago;
    }

    public Reserva(Integer id, Date fechaEntrada, Date fechaSalida, BigDecimal precio, String formaDePago, Huesped huesped) {
        this.id = id;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.precio = precio;
        this.formaDePago = formaDePago;
        this.huesped = huesped;
    }
    
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(Date fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
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
