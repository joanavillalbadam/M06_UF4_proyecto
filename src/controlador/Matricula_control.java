/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Interficies.MatriculaIn;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import model.Matricula;

/**
 *
 * @author ALUMNEDAM
 */
public class Matricula_control implements MatriculaIn{

    @Override
    public Matricula buscarMatricula(Long idMatricula) {
    
        // Recupera el entity manager
        EntityManager em = new Controlador().getEntityManager();

        System.out.println("Busqueda per id Matricula: ");
        Matricula mat = (Matricula) em.find(Matricula.class, idMatricula);

        System.out.println("close");
        em.close();

        return mat;
    
    }

    @Override
    public void Afegir(Matricula mat) {
    
        // Recupera el entity manager
        Controlador oem = new Controlador();
        EntityManager em = oem.getEntityManager();

        // El persistim a la base de dades
        //em.getTransaction().begin();
        EntityTransaction etx = em.getTransaction();

        System.out.println("begin");
        etx.begin();

        System.out.println("persist");
        em.persist(mat);

        System.out.println("commit");
        //em.getTransaction().commit();
        etx.commit();

        System.out.println("close");
        em.close();
    
    }

    @Override
    public void modificar(Matricula m) {
    
        
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
    public void eliminar(Matricula m) {
    
        
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

    
    public List<Matricula> Consulta() {
        // Recupera el entity manager
        EntityManager em = new Controlador().getEntityManager();

        System.out.println("Consulta");
        //List<Persona> lista = (List<Persona>) em.createQuery("FROM Persona").getResultList();
        Query q = em.createQuery("FROM Matricula");
        List<Matricula> lista = (List<Matricula>) q.getResultList();
        
        //imprimirLista(lista);

        System.out.println("close");
        em.close();
        return lista;
    }
    
    public Matricula imprimirLista(List<Matricula> lista, int i) {
        System.out.println("Numero: = " + lista.size());
//        for (int i = 0; i < lista.size(); i++) {
//            System.out.println(lista.get(i));
//        }
        
        return lista.get(i);
    }

    public Long imprimirMatricula(Matricula mat) {
//        System.out.println(mat);
        
        return mat.getIdMatricula();
    }
   

    
    
}
