/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interficies;

import Exceptions.ExceptionBuscar;
import model.Matricula;

/**
 *
 * @author ALUMNEDAM
 */
public interface MatriculaIn extends SuperGenerica<Matricula> {
//Declaramos una interficie que extiende de la clase SuperGenerica para ahorrar lineas de codigo
    public Matricula buscarMatricula(Long idMatricula) throws ExceptionBuscar;
}
