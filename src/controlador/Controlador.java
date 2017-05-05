/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Interficies.CicleIn;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import model.Cicle;

/**
 *
 * @author ALUMNEDAM
 */
public class Controlador {

    public EntityManager getEntityManager() {

        EntityManager em;
        try {

            EntityManagerFactory emf = Persistence.createEntityManagerFactory("INTERNA");
            em = emf.createEntityManager();
        } catch (Exception e) {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("EXTERNA");
            em = emf.createEntityManager();
        }

        return em;
    }
}
