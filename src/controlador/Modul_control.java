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
public class Modul_control implements ModulIn {

    
    public boolean compro = false;
    
    
    @Override
    public Modul buscarModul(String nomModul) {

        // Recupera el entity manager
        EntityManager em = new Controlador().getEntityManager();

        //hacemos la guery
        System.out.println("Busqueda per nom Modul: ");
        Query query = em.createNamedQuery(Modul.CONSULTA, Modul.class);
        //le pasamos el parametro con el que ara el where
        query.setParameter("nombre", nomModul);
        //recojemos el resultado
        Modul mod = (Modul) query.getSingleResult();

        //cerramos la conexion
        System.out.println("close");
        em.close();

        //devolvemos el objeto
        return mod;

    }

    @Override
    public void Afegir(Modul m) {

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
        em.persist(m);

        System.out.println("commit");
        //em.getTransaction().commit();
        etx.commit();

        System.out.println("close");
        em.close();
        
        compro = true;

    }

    @Override
    public void modificar(Modul m) {

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

        //hacemos el begin, remove , commit y cerramos la conexion
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

    public List<Modul> Consulta() {
        // Recupera el entity manager
        EntityManager em = new Controlador().getEntityManager();

        System.out.println("Consulta");
        //List<Persona> lista = (List<Persona>) em.createQuery("FROM Persona").getResultList();
        //creamos el Query
        Query q = em.createQuery("FROM Modul");
        //recogemos el resultado
        List<Modul> lista = (List<Modul>) q.getResultList();
        // imprimirLista(lista);

        //cerramos la conexion
        System.out.println("close");
        em.close();

        //devolvemos la lista
        return lista;
    }

    public Modul imprimirLista(List<Modul> lista, int i) {
        System.out.println("Numero: = " + lista.size());

        //devolvemos el objeto i de la lista
        return lista.get(i);
    }

    public String imprimirModul(Modul mod) {
        System.out.println(mod);
        //devolvemos el nombre del modulo
        return mod.getNomModul();
    }

}
