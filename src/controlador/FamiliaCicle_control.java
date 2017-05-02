/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Interficies.FamiliaIn;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import model.FamiliaCicle;

/**
 *
 * @author ALUMNEDAM
 */
public class FamiliaCicle_control implements FamiliaIn{

    @Override
    public FamiliaCicle buscarFamilia(String nomFamilia) {
    
        // Recupera el entity manager
        EntityManager em = new Controlador().getEntityManager();

        System.out.println("Busqueda per nom Familia Cicle: ");
        Query query = em.createNamedQuery(FamiliaCicle.CONSULTA,FamiliaCicle.class);
        query.setParameter("nombre", nomFamilia);
        FamiliaCicle c = (FamiliaCicle) query.getSingleResult();

        System.out.println("close");
        em.close();

        return c;
    
    }

    @Override
    public void Afegir(FamiliaCicle f) {
    
        // Recupera el entity manager
        Controlador oem = new Controlador();
        EntityManager em = oem.getEntityManager();

        // El persistim a la base de dades
        //em.getTransaction().begin();
        EntityTransaction etx = em.getTransaction();

        System.out.println("begin");
        etx.begin();

        System.out.println("persist");
        em.persist(f);

        System.out.println("commit");
        //em.getTransaction().commit();
        etx.commit();

        System.out.println("close");
        em.close();
    
    }

    @Override
    public void modificar(FamiliaCicle f) {
    
        
        // Recupera el entity manager
        Controlador oem = new Controlador();
        EntityManager em = oem.getEntityManager();

        // El persistim a la base de dades
        //em.getTransaction().begin();
        EntityTransaction etx = em.getTransaction();

        System.out.println("begin");
        etx.begin();

        System.out.println("merge");
        em.merge(f);

        System.out.println("commit");
        //em.getTransaction().commit();
        etx.commit();

        System.out.println("close");
        em.close();
    
    }

    @Override
    public void eliminar(FamiliaCicle f) {
        
        
         // Recupera el entity manager
        Controlador oem = new Controlador();
        EntityManager em = oem.getEntityManager();

        // El persistim a la base de dades
        //em.getTransaction().begin();
        EntityTransaction etx = em.getTransaction();

        System.out.println("begin");
        etx.begin();

        System.out.println("remove");
        em.remove(em.contains(f) ? f : em.merge(f));

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
        Query q = em.createQuery("FROM FamiliaCicle");
        List<FamiliaCicle> lista = (List<FamiliaCicle>) q.getResultList();
        imprimirLista(lista);

        System.out.println("close");
        em.close();
    }
    
    public void imprimirLista(List<FamiliaCicle> lista) {
        System.out.println("Numero: = " + lista.size());
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(lista.get(i));
        }
    }

    public void imprimirFamiliaCicle(FamiliaCicle fam) {
        System.out.println(fam);
    }


   
    
}
