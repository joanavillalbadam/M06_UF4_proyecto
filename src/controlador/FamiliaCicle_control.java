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
public class FamiliaCicle_control implements FamiliaIn {

    public boolean compro = false;
    
    
    @Override
    public FamiliaCicle buscarFamilia(String nomFamilia) {

        // Recupera el entity manager
        EntityManager em = new Controlador().getEntityManager();

         //hacemos la guery
        System.out.println("Busqueda per nom Familia Cicle: ");
        Query query = em.createNamedQuery(FamiliaCicle.CONSULTA, FamiliaCicle.class);
        //le pasamos el parametro con el que ara el where
        query.setParameter("nombre", nomFamilia);
        //recojemos el resultado
        FamiliaCicle c = (FamiliaCicle) query.getSingleResult();

        //cerramos la conexion
        System.out.println("close");
        em.close();

        //devolvemos el objeto
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

        //hacemos el begin, persist y commit y cerramos la conexion
        System.out.println("begin");
        etx.begin();

        System.out.println("persist");
        em.persist(f);

        System.out.println("commit");
        //em.getTransaction().commit();
        etx.commit();

        System.out.println("close");
        em.close();
        
        compro = true;

    }

    @Override
    public void modificar(FamiliaCicle f) {

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

         //hacemos el begin, remove , commit y cerramos la conexion
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

    public List<FamiliaCicle> Consulta() {
        // Recupera el entity manager
        EntityManager em = new Controlador().getEntityManager();

        System.out.println("Consulta");
        //List<Persona> lista = (List<Persona>) em.createQuery("FROM Persona").getResultList();
        //creamos el Query
        Query q = em.createQuery("FROM FamiliaCicle");
         //recogemos el resultado
        List<FamiliaCicle> lista = (List<FamiliaCicle>) q.getResultList();
        //imprimirLista(lista);

        //cerramos la conexion
        System.out.println("close");
        em.close();
        //devolvemos la lista
        return lista;
    }

    public FamiliaCicle imprimirLista(List<FamiliaCicle> lista, int i) {
        System.out.println("Numero: = " + lista.size());
        //devolvemos el objeto i de la lista
        return lista.get(i);
    }

    public String imprimirFamiliaCicle(FamiliaCicle fam) {
        System.out.println(fam);
        //devolvemos el nombre de familia
        return fam.getNombreFamilia();
    }

}
