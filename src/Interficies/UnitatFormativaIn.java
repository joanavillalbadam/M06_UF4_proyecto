/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interficies;

import Exceptions.ExceptionBuscar;
import model.UnitatFormativa;

/**
 *
 * @author ALUMNEDAM
 */
public interface UnitatFormativaIn extends SuperGenerica<UnitatFormativa> {

    public UnitatFormativa buscarUF(String nomUnitat) throws ExceptionBuscar;
}
