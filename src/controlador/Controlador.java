/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author ALUMNEDAM
 */
public class Controlador {
    
    public EntityManager getEntityManager() {
        
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("INTERNA");
    //EntityManagerFactory emf = Persistence.createEntityManagerFactory("EXTERNA");
        EntityManager em = emf.createEntityManager();
        return em;
    }
}