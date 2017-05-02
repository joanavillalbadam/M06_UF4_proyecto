/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Interficies.AlumneIn;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import model.Alumne;

/**
 *
 * @author ALUMNEDAM
 */
public class Alumne_control implements AlumneIn{

    @Override
    public Alumne buscarPorNombre(String nom) {
    
        // Recupera el entity manager
        EntityManager em = new Controlador().getEntityManager();

        System.out.println("Busqueda per nom Alumne: ");
        Query query = em.createNamedQuery(Alumne.CONSULTA,Alumne.class);
        query.setParameter("nombre", nom);
        Alumne c = (Alumne) query.getSingleResult();

        System.out.println("close");
        em.close();

        return c;
    
    }

    @Override
    public void Afegir(Alumne a) {
    
        // Recupera el entity manager
        Controlador oem = new Controlador();
        EntityManager em = oem.getEntityManager();

        // El persistim a la base de dades
        //em.getTransaction().begin();
        EntityTransaction etx = em.getTransaction();

        System.out.println("begin");
        etx.begin();

        System.out.println("persist");
        em.persist(a);

        System.out.println("commit");
        //em.getTransaction().commit();
        etx.commit();

        System.out.println("close");
        em.close();
    
    }
    
    @Override
    public void modificar(Alumne a) {
    
        // Recupera el entity manager
        controlador.Controlador oem = new controlador.Controlador();
        EntityManager em = oem.getEntityManager();

        // El persistim a la base de dades
        //em.getTransaction().begin();
        EntityTransaction etx = em.getTransaction();

        System.out.println("begin");
        etx.begin();

        System.out.println("merge");
        em.merge(a);

        System.out.println("commit");
        //em.getTransaction().commit();
        etx.commit();

        System.out.println("close");
        em.close();
    
    }

    @Override
    public void eliminar(Alumne a) {
    
        // Recupera el entity manager
        controlador.Controlador oem = new controlador.Controlador();
        EntityManager em = oem.getEntityManager();

        // El persistim a la base de dades
        //em.getTransaction().begin();
      EntityTransaction etx = em.getTransaction();

        System.out.println("begin");
        etx.begin();

        System.out.println("remove");
        em.remove(em.contains(a) ? a : em.merge(a));

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
        List<Alumne> lista = (List<Alumne>) q.getResultList();
        imprimirLista(lista);

        System.out.println("close");
        em.close();
    }
    
    public void imprimirLista(List<Alumne> lista) {
        System.out.println("Numero: = " + lista.size());
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(lista.get(i));
        }
    }

    public void imprimirAlumne(Alumne alumne) {
        System.out.println(alumne);
    }

    

   
    
}
