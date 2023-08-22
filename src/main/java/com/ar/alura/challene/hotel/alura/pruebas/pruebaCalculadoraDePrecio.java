/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ar.alura.challene.hotel.alura.pruebas;

import com.ar.alura.challene.hotel.alura.utils.CalculadoraDePrecioUtils;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author marti
 */
public class pruebaCalculadoraDePrecio {
    
    public static void main(String[] args) {
        
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

        CalculadoraDePrecioUtils calcu = new CalculadoraDePrecioUtils();

        BigDecimal precio = calcu.calcularPrecio(fechaInicio, fechaFinal, formaDePago);
        
        float precioEsperado = (float) (1000 + 50 - 50*0.2);
        System.out.println("El precio esperado es de " + String.valueOf(precioEsperado));
        System.out.println("El precio obtenido fue: " + String.valueOf(precio));
    }
    
}
