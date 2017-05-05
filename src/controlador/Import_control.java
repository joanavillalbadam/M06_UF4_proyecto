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

    
    public boolean compro = false;
    
    
    @Override
    public Import buscarImporte(Long idImport) {

        // Recupera el entity manager
        EntityManager em = new Controlador().getEntityManager();

        //hacemos la guery
        System.out.println("Busqueda per id Import: ");
        //recojemos el resultado
        Import imp = (Import) em.find(Import.class, idImport);

        //cerramos la conexion
        System.out.println("close");
        em.close();

        //devolvemos el objeto
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

        //hacemos el begin, persist y commit y cerramos la conexion
        System.out.println("begin");
        etx.begin();

        System.out.println("persist");
        em.persist(imp);

        System.out.println("commit");
        //em.getTransaction().commit();
        etx.commit();

        System.out.println("close");
        em.close();
        
        compro = true;

    }

    @Override
    public void modificar(Import imp) {
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

        //hacemos el begin, remove , commit y cerramos la conexion
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
        //creamos el Query
        Query q = em.createQuery("FROM Import");
        //recogemos el resultado
        List<Import> lista = (List<Import>) q.getResultList();
        //imprimirLista(lista);

        //cerramos la conexion
        System.out.println("close");
        em.close();

        //devolvemos la lista
        return lista;
    }

    public Import imprimirLista(List<Import> lista, int i) {
        System.out.println("Numero: = " + lista.size());
        //devolvemos el objeto i de la lista
        return lista.get(i);
    }

    public Long imprimirImport(Import imp) {
        System.out.println(imp);
        //devolvemos el Id del importe
        return imp.getIdImport();
    }

}
