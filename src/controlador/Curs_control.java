/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Interficies.CursIn;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import model.Curs;

/**
 *
 * @author ALUMNEDAM
 */
public class Curs_control implements CursIn {

    
    public boolean compro = false;
    
    @Override
    public Curs buscarCurso(Long idCurs) {
        // Recupera el entity manager
        EntityManager em = new Controlador().getEntityManager();

        System.out.println("Busqueda per id curs: ");
        //recogemos el resultado
        Curs curs = (Curs) em.find(Curs.class, idCurs);

        //cerramos la conexion
        System.out.println("close");
        em.close();

        //devolvemos el objeto
        return curs;
    }

    @Override
    public void Afegir(Curs c) {

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
    public void modificar(Curs c) {

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
    public void eliminar(Curs c) {

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

    public List<Curs> Consulta() {
        // Recupera el entity manager
        EntityManager em = new Controlador().getEntityManager();

        System.out.println("Consulta");
        //List<Persona> lista = (List<Persona>) em.createQuery("FROM Persona").getResultList();
        //creamos el Query
        Query q = em.createQuery("FROM Curs");
        //recogemos el resultado
        List<Curs> lista = (List<Curs>) q.getResultList();
        //imprimirLista(lista);

        //cerramos la conexion
        System.out.println("close");
        em.close();

           //devolvemos la lista
        return lista;
    }

    public Curs imprimirLista(List<Curs> lista, int i) {
        System.out.println("Numero: = " + lista.size());
        //devolvemos el objeto i de la lista
        return lista.get(i);
    }

    public String imprimirCurs(Curs c) {
        System.out.println(c);
         //devolvemos el numero del curso
        return c.getPrimSegun();
    }

}
