/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Interficies.ModulIn;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import model.Modul;

/**
 *
 * @author ALUMNEDAM
 */
public class Modul_control implements ModulIn{

    @Override
    public Modul buscarModul(String nomModul) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Afegir(Modul m) {
    
        // Recupera el entity manager
        Controlador oem = new Controlador();
        EntityManager em = oem.getEntityManager();

        // El persistim a la base de dades
        //em.getTransaction().begin();
        EntityTransaction etx = em.getTransaction();

        System.out.println("begin");
        etx.begin();

        System.out.println("persist");
        em.persist(m);

        System.out.println("commit");
        //em.getTransaction().commit();
        etx.commit();

        System.out.println("close");
        em.close();
    
    }

    @Override
    public void modificar(Modul m) {
    
        
        
        // Recupera el entity manager
        Controlador oem = new Controlador();
        EntityManager em = oem.getEntityManager();

        // El persistim a la base de dades
        //em.getTransaction().begin();
        EntityTransaction etx = em.getTransaction();

        System.out.println("begin");
        etx.begin();

        System.out.println("merge");
        em.merge(m);

        System.out.println("commit");
        //em.getTransaction().commit();
        etx.commit();

        System.out.println("close");
        em.close();
    
    }

    @Override
    public void eliminar(Modul m) {
    
        
         // Recupera el entity manager
        Controlador oem = new Controlador();
        EntityManager em = oem.getEntityManager();

        // El persistim a la base de dades
        //em.getTransaction().begin();
        EntityTransaction etx = em.getTransaction();

        System.out.println("begin");
        etx.begin();

        System.out.println("remove");
        em.remove(em.contains(m) ? m : em.merge(m));

        System.out.println("commit");
        //em.getTransaction().commit();
        etx.commit();

        System.out.println("close");
        em.close();
    
    }

   
    
    public void Consulta() {
        // Recupera el entity manager
        EntityManager em = new Controlador().getEntityManager();

        System.out.println("Consulta");
        //List<Persona> lista = (List<Persona>) em.createQuery("FROM Persona").getResultList();
        Query q = em.createQuery("FROM Curs");
        List<Modul> lista = (List<Modul>) q.getResultList();
        imprimirLista(lista);

        System.out.println("close");
        em.close();
    }
    
    public void imprimirLista(List<Modul> lista) {
        System.out.println("Numero: = " + lista.size());
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(lista.get(i));
        }
    }

    public void imprimirPersona(Modul mod) {
        System.out.println(mod);
    }

   
    
}
