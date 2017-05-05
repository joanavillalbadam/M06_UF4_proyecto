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
public class ExceptionModificar extends Exception{
    
    public ExceptionModificar() {
        System.err.println("Error al modificar en la base de dato.");
    }
    
}
