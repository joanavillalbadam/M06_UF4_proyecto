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
import Exceptions.*;

/**
 *
 * @author ALUMNEDAM
 */
public class Alumne_control implements AlumneIn {
    
    public boolean compro = false;

    @Override
    public Alumne buscarPorNombre(String nom)  {

        // Recupera el entity manager
        EntityManager em = new Controlador().getEntityManager();
        //hacemos la guery
        System.out.println("Busqueda per nom Alumne: ");
        Query query = em.createNamedQuery(Alumne.CONSULTA, Alumne.class);
        //le pasamos el parametro con el que ara el where
        query.setParameter("nombre", nom);
        //recojemos el resultado
        Alumne c = (Alumne) query.getSingleResult();
        //cerramos la conexion
        System.out.println("close");
        em.close();
        //devolvemos el objeto
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

        //hacemos el begin, persist y commit y cerramos la conexion
        System.out.println("begin");
        etx.begin();

        System.out.println("persist");
        em.persist(a);

        System.out.println("commit");
        //em.getTransaction().commit();
        etx.commit();

        System.out.println("close");
        em.close();
        compro = true;
        

    }

    @Override
    public void modificar(Alumne a) {

        // Recupera el entity manager
        controlador.Controlador oem = new controlador.Controlador();
        EntityManager em = oem.getEntityManager();

        // El persistim a la base de dades
        //em.getTransaction().begin();
        EntityTransaction etx = em.getTransaction();

        //hacemos el begin, merge y commit y cerramos la conexion
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

        //hacemos el begin, remove , commit y cerramos la conexion
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

    public List<Alumne> Consulta() {
        // Recupera el entity manager
        EntityManager em = new Controlador().getEntityManager();

        System.out.println("Consulta");
        //creamos el Query
        Query q = em.createQuery("FROM Alumne");
        //recogemos el resultado
        List<Alumne> lista = (List<Alumne>) q.getResultList();

        //cerramos la conexion
        System.out.println("close");
        em.close();
        
        //devolvemos la lista
        return lista;
    }

    public Alumne imprimirLista(List<Alumne> lista, int i) {
        System.out.println("Numero: = " + lista.size());
        //devolvemos el objeto i de la lista
        return lista.get(i);
    }

    public String imprimirAlumne(Alumne alumne) {
        System.out.println(alumne);
        //devolvemos el nif del alumno
        return alumne.getNif();
    }

}
