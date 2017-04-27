/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interficies;

import model.Modul;

/**
 *
 * @author ALUMNEDAM
 */
public interface ModulIn extends SuperGenerica<Modul> {

    public Modul buscarModul(String nomModul);
}
