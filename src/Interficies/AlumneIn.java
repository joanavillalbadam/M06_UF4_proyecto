/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interficies;

import Exceptions.ExceptionBuscar;
import model.Alumne;

/**
 *
 * @author ALUMNEDAM
 */
public interface AlumneIn extends SuperGenerica<Alumne> {
    //Declaramos una interficie que extiende de la clase SuperGenerica para ahorrar lineas de codigo
    public Alumne buscarPorNombre(String nom)throws ExceptionBuscar;
    
}
