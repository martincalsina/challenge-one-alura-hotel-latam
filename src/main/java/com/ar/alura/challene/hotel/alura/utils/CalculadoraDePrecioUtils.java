/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ar.alura.challene.hotel.alura.utils;

import java.math.BigDecimal;
import java.math.MathContext;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;

/**
 *
 * @author marti
 */
public class CalculadoraDePrecioUtils {
    
    private static BigDecimal tasaFija = new BigDecimal(1000);
    private static BigDecimal precioPorDia = new BigDecimal(50);
    
    public CalculadoraDePrecioUtils() {
    }
    
    public BigDecimal calcularPrecio(Date fechaInicial, Date fechaFinal, String formaDePago) {
        MathContext mc = new MathContext(8);
        BigDecimal precioAcumulado = this.tasaFija;
        
        LocalDate localFechaInicial = fechaInicial.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate localFechaFinal = fechaFinal.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        
        BigDecimal diferenciaDias = new BigDecimal(ChronoUnit.DAYS.between(localFechaInicial, localFechaFinal));
        precioAcumulado = precioAcumulado.add(diferenciaDias.multiply(precioPorDia));
        BigDecimal descuento = this.calcularDescuento(formaDePago);
        precioAcumulado = precioAcumulado.subtract(precioPorDia.multiply(descuento), mc);
        return precioAcumulado;
    }
    
    private BigDecimal calcularDescuento(String formaDePago) {
        BigDecimal descuento = new BigDecimal(0);
     
        if (formaDePago.equals("Efectivo")) {
            descuento = descuento.add(new BigDecimal(0.2));
        } else if (formaDePago.equals("Credito")) {
            descuento = descuento.add(new BigDecimal(0.1));
        }
        return descuento;
    }
    
}
