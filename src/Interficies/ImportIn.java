/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interficies;

import model.Import;

/**
 *
 * @author ALUMNEDAM
 */
public interface ImportIn extends SuperGenerica<Import> {

    public Import buscarImporte(Long idImport);
}
