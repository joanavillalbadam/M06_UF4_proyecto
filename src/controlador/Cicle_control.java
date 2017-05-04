/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Interficies.CicleIn;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import model.Cicle;

/**
 *
 * @author ALUMNEDAM
 */
public class Cicle_control implements CicleIn{

    
    public boolean compro = false;
    
    @Override
    public Cicle buscarCiclo(String nomCicle) {
    
        // Recupera el entity manager
        EntityManager em = new Controlador().getEntityManager();

        System.out.println("Busqueda per nom Cicle: ");
        Query query = em.createNamedQuery(Cicle.CONSULTA,Cicle.class);
        query.setParameter("nombre", nomCicle);
        Cicle c = (Cicle) query.getSingleResult();

        System.out.println("close");
        em.close();

        return c;
        
    
    }

    @Override
    public void Afegir(Cicle c) {
        
        // Recupera el entity manager
        Controlador oem = new Controlador();
        EntityManager em = oem.getEntityManager();

        // El persistim a la base de dades
        //em.getTransaction().begin();
        EntityTransaction etx = em.getTransaction();

        System.out.println("begin");
        etx.begin();

        System.out.println("persist");
        em.persist(c);

        System.out.println("commit");
        //em.getTransaction().commit();
        etx.commit();

        System.out.println("close");
        em.close();
        compro = true;
    
        
    }

    @Override
    public void modificar(Cicle c) {
        
    
        // Recupera el entity manager
        Controlador oem = new Controlador();
        EntityManager em = oem.getEntityManager();

        // El persistim a la base de dades
        //em.getTransaction().begin();
        EntityTransaction etx = em.getTransaction();

        System.out.println("begin");
        etx.begin();

        System.out.println("merge");
        em.merge(c);

        System.out.println("commit");
        //em.getTransaction().commit();
        etx.commit();

        System.out.println("close");
        em.close();
    
    
    }

    @Override
    public void eliminar(Cicle c) {
    
        
         // Recupera el entity manager
        Controlador oem = new Controlador();
        EntityManager em = oem.getEntityManager();

        // El persistim a la base de dades
        //em.getTransaction().begin();
        EntityTransaction etx = em.getTransaction();

        System.out.println("begin");
        etx.begin();

        System.out.println("remove");
        em.remove(em.contains(c) ? c : em.merge(c));

        System.out.println("commit");
        //em.getTransaction().commit();
        etx.commit();

        System.out.println("close");
        em.close();
    
    
    }
    
    public List<Cicle> Consulta() {
        // Recupera el entity manager
        EntityManager em = new Controlador().getEntityManager();

        System.out.println("Consulta");
        //List<Persona> lista = (List<Persona>) em.createQuery("FROM Persona").getResultList();
        Query q = em.createQuery("FROM Cicle");
        List<Cicle> lista = (List<Cicle>) q.getResultList();
        //imprimirLista(lista);

        System.out.println("close");
        em.close();
        
//        for (int i = 0; i < lista.size(); i++) {
//            System.out.println(lista.get(i));
//        }
        return lista;
    }
    
    public Cicle imprimirLista(List<Cicle> lista, int i) {
        System.out.println("Numero: = " + lista.size());
        return lista.get(i);
    }

    public String imprimirCicle(Cicle c) {
        System.out.println(c);
        return c.getNombreCicle();
    }


    
    
}
