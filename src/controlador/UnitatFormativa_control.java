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
public class UnitatFormativa_control implements UnitatFormativaIn {

    
    public boolean compro = false;
    
    
    @Override
    public UnitatFormativa buscarUF(String nomUnitat) {

        // Recupera el entity manager
        EntityManager em = new Controlador().getEntityManager();

        //hacemos la guery
        System.out.println("Busqueda per nom UF: ");
        //le pasamos el parametro con el que ara el where
        Query query = em.createNamedQuery(UnitatFormativa.CONSULTA, UnitatFormativa.class);
        query.setParameter("nombre", nomUnitat);
        //recojemos el resultado
        UnitatFormativa uf = (UnitatFormativa) query.getSingleResult();

        //cerramos la conexion
        System.out.println("close");
        em.close();

        //devolvemos el objeto
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

        //hacemos el begin, persist y commit y cerramos la conexion
        System.out.println("begin");
        etx.begin();

        System.out.println("persist");
        em.persist(uf);

        System.out.println("commit");
        //em.getTransaction().commit();
        etx.commit();

        System.out.println("close");
        em.close();
        
        compro = true;

    }

    @Override
    public void modificar(UnitatFormativa uf) {

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

        //hacemos el begin, remove , commit y cerramos la conexion
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

    public List<UnitatFormativa> Consulta() {
        // Recupera el entity manager
        EntityManager em = new Controlador().getEntityManager();

        //creamos el Query
        System.out.println("Consulta");
        //List<Persona> lista = (List<Persona>) em.createQuery("FROM Persona").getResultList();
        //recogemos el resultado
        Query q = em.createQuery("FROM UnitatFormativa");
        List<UnitatFormativa> lista = (List<UnitatFormativa>) q.getResultList();
        //imprimirLista(lista);

        //cerramos la conexion
        System.out.println("close");
        em.close();

        //devolvemos la lista
        return lista;
    }

    public UnitatFormativa imprimirLista(List<UnitatFormativa> lista, int i) {
        System.out.println("Numero: = " + lista.size());
        //devolvemos el objeto i de la lista
        return lista.get(i);
    }

    public String imprimirUnitatFormativa(UnitatFormativa uf) {
        System.out.println(uf);
        //devolvemos el nombre de la unidad
        return uf.getNomUnitat();
    }

}
