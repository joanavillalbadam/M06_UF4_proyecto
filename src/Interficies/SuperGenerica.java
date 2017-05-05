/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interficies;

import Exceptions.*;

/**
 *
 * @author ALUMNEDAM
 */
public interface SuperGenerica<T>{
    
    public void Afegir(T t) throws ExceptionAfegir;
    public void modificar(T t) throws ExceptionModificar;
    public void eliminar(T t) throws ExceptionEliminar;
    
    
}
