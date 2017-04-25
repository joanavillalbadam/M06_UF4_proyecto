/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Interficies.AlumneIn;
import javax.persistence.EntityManager;
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

        System.out.println("busqueda");
        Query query = em.createNamedQuery(Alumne.CONSULTA,Alumne.class);
        query.setParameter("nombre", nom);
        Alumne c = (Alumne) query.getSingleResult();

        System.out.println("close");
        em.close();

        return c;
    
    }

    @Override
    public void Afegir(Alumne t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(Alumne t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modificar(Alumne t, Alumne nuevoT) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    
}
