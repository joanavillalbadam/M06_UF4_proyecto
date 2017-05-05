/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interficies;

import Exceptions.ExceptionBuscar;
import model.FamiliaCicle;

/**
 *
 * @author ALUMNEDAM
 */
public interface FamiliaIn extends SuperGenerica<FamiliaCicle> {

    public FamiliaCicle buscarFamilia(String nomFamilia) throws ExceptionBuscar;

}
