/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m6_practica_persistence;

import controlador.*;
import model.Alumne;

/**
 *
 * @author ALUMNEDAM
 */
public class M6_Practica_Persistence {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        /**
         DROP TABLE M6UF2_Adreca; 
         DROP TABLE M6UF2_POLISSA; 
         DROP TABLE M6UF2_USUARI; 
         DROP TABLE VEHICLES;
         DROP TABLE M6UF2_CLIENT; 
         DROP TABLE M6UF2_Asseguradora; 
         */
        
        Alumne_control ac = new Alumne_control();
        Alumne al = new Alumne("77128797E","joana","villalba","joana@gmail.com",671576281);
        ac.Afegir(al);
        
        
    }
    
}
