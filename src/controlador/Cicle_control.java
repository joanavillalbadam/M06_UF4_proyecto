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

        //hacemos la guery
        System.out.println("Busqueda per nom Cicle: ");
        Query query = em.createNamedQuery(Cicle.CONSULTA,Cicle.class);
        //le pasamos el parametro con el que ara el where
        query.setParameter("nombre", nomCicle);
        //recojemos el resultado
        Cicle c = (Cicle) query.getSingleResult();

        //cerramos la conexion
        System.out.println("close");
        em.close();
        //devolvemos el objeto
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

        //hacemos el begin, persist y commit y cerramos la conexion
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
        //hacemos el begin, merge y commit y cerramos la conexion
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

        //hacemos el begin, remove , commit y cerramos la conexion
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
        //creamos el Query
        Query q = em.createQuery("FROM Cicle");
        //recogemos el resultado
        List<Cicle> lista = (List<Cicle>) q.getResultList();
        //imprimirLista(lista);
        //cerramos la conexion
        System.out.println("close");
        em.close();
        

    //devolvemos la lista
        return lista;
    }
    
    public Cicle imprimirLista(List<Cicle> lista, int i) {
        System.out.println("Numero: = " + lista.size());
        //devolvemos el objeto i de la lista
        return lista.get(i);
    }

    public String imprimirCicle(Cicle c) {
        System.out.println(c);
         //devolvemos el nombre del ciclo
        return c.getNombreCicle();
    }


    
    
}
