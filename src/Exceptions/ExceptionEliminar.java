/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exceptions;

/**
 *
 * @author ALUMNEDAM
 */
public class ExceptionEliminar extends Exception{
    
    public ExceptionEliminar() {
        System.err.println("Error al eliminar a la base de dato.");
    }
}
