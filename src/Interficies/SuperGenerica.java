/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interficies;

/**
 *
 * @author ALUMNEDAM
 */
public interface SuperGenerica<T>{
    
    public void Afegir(T t);
    public void eliminar(T t);
    public void modificar(T t, T nuevoT);
    
}
