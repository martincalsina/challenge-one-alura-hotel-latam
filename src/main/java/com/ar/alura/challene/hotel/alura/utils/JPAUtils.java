/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ar.alura.challene.hotel.alura.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author marti
 */
public class JPAUtils {
    
    private static EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("hotel_alura");
	
    public static EntityManager getEntityManager() {
		return FACTORY.createEntityManager();
    }
}
    

