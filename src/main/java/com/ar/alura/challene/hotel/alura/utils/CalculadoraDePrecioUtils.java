/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ar.alura.challene.hotel.alura.utils;

import java.math.BigDecimal;
import java.time.LocalDate;
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
    
    public BigDecimal calcularPrecio(LocalDate fechaInicial, LocalDate fechaFinal, String formaDePago) {
        BigDecimal precioAcumulado = this.tasaFija;
        BigDecimal diferenciaDias = new BigDecimal(ChronoUnit.DAYS.between(fechaInicial, fechaFinal));
        precioAcumulado.add(diferenciaDias.multiply(precioPorDia));
        BigDecimal descuento = this.calcularDescuento(formaDePago);
        precioAcumulado.add (precioPorDia.multiply(descuento).negate());
        return precioAcumulado;
    }
    
    private BigDecimal calcularDescuento(String formaDePago) {
        BigDecimal descuento = new BigDecimal(0);
     
        if (formaDePago.equals("Efectivo")) {
            descuento.add(new BigDecimal(0.2));
        } else if (formaDePago.equals("Credito")) {
            descuento.add(new BigDecimal(0.1));
        }
        return descuento;
    }
    
}
