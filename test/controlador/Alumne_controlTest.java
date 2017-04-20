/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import model.Alumne;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ALUMNEDAM
 */
public class Alumne_controlTest {
    
    public Alumne_controlTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of Afegir method, of class Alumne_control.
     */
    @Test
    public void testAfegir() {
        System.out.println("Afegir");
        Object t = null;
        Alumne_control instance = new Alumne_control();
        instance.Afegir((Alumne) t);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of eliminar method, of class Alumne_control.
     */
    @Test
    public void testEliminar() {
        System.out.println("eliminar");
        Object t = null;
        Alumne_control instance = new Alumne_control();
        instance.eliminar((Alumne) t);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of modificar method, of class Alumne_control.
     */
    @Test
    public void testModificar() {
        System.out.println("modificar");
        Object t = null;
        Object nuevoT = null;
        Alumne_control instance = new Alumne_control();
        //instance.modificar(t, nuevoT);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscarPorNombre method, of class Alumne_control.
     */
    @Test
    public void testBuscarPorNombre() {
        System.out.println("buscarPorNombre");
        Alumne_control instance = new Alumne_control();
        instance.buscarPorNombre();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
