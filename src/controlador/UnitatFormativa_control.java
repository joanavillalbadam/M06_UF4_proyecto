/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Interficies.UnitatFormativaIn;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import model.UnitatFormativa;

/**
 *
 * @author ALUMNEDAM
 */
public class UnitatFormativa_control implements UnitatFormativaIn{

    @Override
    public UnitatFormativa buscarUF(String nomUnitat) {
    
        
        // Recupera el entity manager
        EntityManager em = new Controlador().getEntityManager();

        System.out.println("Busqueda per nom UF: ");
        Query query = em.createNamedQuery(UnitatFormativa.CONSULTA,UnitatFormativa.class);
        query.setParameter("nombre", nomUnitat);
        UnitatFormativa uf = (UnitatFormativa) query.getSingleResult();

        System.out.println("close");
        em.close();

        return uf;
    
    
    }

    @Override
    public void Afegir(UnitatFormativa uf) {
    
        // Recupera el entity manager
        Controlador oem = new Controlador();
        EntityManager em = oem.getEntityManager();

        // El persistim a la base de dades
        //em.getTransaction().begin();
        EntityTransaction etx = em.getTransaction();

        System.out.println("begin");
        etx.begin();

        System.out.println("persist");
        em.persist(uf);

        System.out.println("commit");
        //em.getTransaction().commit();
        etx.commit();

        System.out.println("close");
        em.close();
    
    }

    @Override
    public void modificar(UnitatFormativa uf) {
    
        
        // Recupera el entity manager
        Controlador oem = new Controlador();
        EntityManager em = oem.getEntityManager();

        // El persistim a la base de dades
        //em.getTransaction().begin();
        EntityTransaction etx = em.getTransaction();

        System.out.println("begin");
        etx.begin();

        System.out.println("merge");
        em.merge(uf);

        System.out.println("commit");
        //em.getTransaction().commit();
        etx.commit();

        System.out.println("close");
        em.close();
    
    }

    @Override
    public void eliminar(UnitatFormativa uf) {
    
        
         // Recupera el entity manager
        Controlador oem = new Controlador();
        EntityManager em = oem.getEntityManager();

        // El persistim a la base de dades
        //em.getTransaction().begin();
        EntityTransaction etx = em.getTransaction();

        System.out.println("begin");
        etx.begin();

        System.out.println("remove");
        em.remove(em.contains(uf) ? uf : em.merge(uf));

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
        Query q = em.createQuery("FROM UnitatFormativa");
        List<UnitatFormativa> lista = (List<UnitatFormativa>) q.getResultList();
        imprimirLista(lista);

        System.out.println("close");
        em.close();
    }
    
    public void imprimirLista(List<UnitatFormativa> lista) {
        System.out.println("Numero: = " + lista.size());
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(lista.get(i));
        }
    }

    public void imprimirUnitatFormativa(UnitatFormativa uf) {
        System.out.println(uf);
    }

    

    
    
}
