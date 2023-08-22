/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ar.alura.challene.hotel.alura.pruebas;

import com.ar.alura.challene.hotel.alura.utils.CalculadoraDePrecioUtils;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 *
 * @author marti
 */
public class pruebaCalculadoraDePrecio {
    
    public static void main(String[] args) {
        LocalDate fechaInicio = LocalDate.of(2014, 6, 29);
        LocalDate fechaFinal = LocalDate.of(2014, 6, 30);
        String formaDePago = "Efectivo";

        CalculadoraDePrecioUtils calcu = new CalculadoraDePrecioUtils();

        BigDecimal precio = calcu.calcularPrecio(fechaInicio, fechaFinal, formaDePago);
        
        float precioEsperado = (float) (1000 + 50 - 50*0.2);
        System.out.println("El precio esperado es de " + String.valueOf(precioEsperado));
        System.out.println("El precio obtenido fue: " + String.valueOf(precio));
    }
    
}
