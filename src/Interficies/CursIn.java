/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interficies;

import Exceptions.ExceptionBuscar;
import model.Curs;

/**
 *
 * @author ALUMNEDAM
 */
public interface CursIn extends SuperGenerica<Curs>{
    public Curs buscarCurso(Long idCurs) throws ExceptionBuscar;
}
