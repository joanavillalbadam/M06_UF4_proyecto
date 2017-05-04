/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Interficies.CursIn;
import Interficies.ImportIn;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import model.Curs;
import model.Import;

/**
 *
 * @author ALUMNEDAM
 */
public class Import_control implements ImportIn {

    @Override
    public Import buscarImporte(Long idImport) {

        // Recupera el entity manager
        EntityManager em = new Controlador().getEntityManager();

        System.out.println("Busqueda per id Import: ");
        Import imp = (Import) em.find(Import.class, idImport);

        System.out.println("close");
        em.close();

        return imp;

    }

    @Override
    public void Afegir(Import imp) {

        // Recupera el entity manager
        Controlador oem = new Controlador();
        EntityManager em = oem.getEntityManager();

        // El persistim a la base de dades
        //em.getTransaction().begin();
        EntityTransaction etx = em.getTransaction();

        System.out.println("begin");
        etx.begin();

        System.out.println("persist");
        em.persist(imp);

        System.out.println("commit");
        //em.getTransaction().commit();
        etx.commit();

        System.out.println("close");
        em.close();

    }

    @Override
    public void modificar(Import imp) {
        // Recupera el entity manager
        Controlador oem = new Controlador();
        EntityManager em = oem.getEntityManager();

        // El persistim a la base de dades
        //em.getTransaction().begin();
        EntityTransaction etx = em.getTransaction();

        System.out.println("begin");
        etx.begin();

        System.out.println("merge");
        em.merge(imp);

        System.out.println("commit");
        //em.getTransaction().commit();
        etx.commit();

        System.out.println("close");
        em.close();
    }

    @Override
    public void eliminar(Import imp) {
        // Recupera el entity manager
        Controlador oem = new Controlador();
        EntityManager em = oem.getEntityManager();

        // El persistim a la base de dades
        //em.getTransaction().begin();
        EntityTransaction etx = em.getTransaction();

        System.out.println("begin");
        etx.begin();

        System.out.println("remove");
        em.remove(em.contains(imp) ? imp : em.merge(imp));

        System.out.println("commit");
        //em.getTransaction().commit();
        etx.commit();

        System.out.println("close");
        em.close();
    }

    public List<Import> Consulta() {
        // Recupera el entity manager
        EntityManager em = new Controlador().getEntityManager();

        System.out.println("Consulta");
        //List<Persona> lista = (List<Persona>) em.createQuery("FROM Persona").getResultList();
        Query q = em.createQuery("FROM Import");
        List<Import> lista = (List<Import>) q.getResultList();
        //imprimirLista(lista);

        System.out.println("close");
        em.close();

        return lista;
    }

    public Import imprimirLista(List<Import> lista, int i) {
        System.out.println("Numero: = " + lista.size());
//        for (int i = 0; i < lista.size(); i++) {
//            System.out.println(lista.get(i));
//        }
        return lista.get(i);
    }

    public double imprimirImport(Import imp) {
//        System.out.println(imp);
        return imp.getImporte();
    }

}
