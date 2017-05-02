/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m6_practica_persistence;

import controlador.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
import model.Alumne;
import model.Cicle;
import model.Curs;
import model.FamiliaCicle;
import model.Import;
import model.Matricula;
import model.Modul;
import model.UnitatFormativa;

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
         
        Drop Table M6UF4_ALUMNE;
        
        Drop Table M6UF4_MATRICULA;
        Drop Table M6UF4_IMPORT;
        
        Drop Table M6UF4_UNITATFORMATIVA;
        Drop Table M6UF4_Modul; 
        Drop Table M6UF4_CURS;
        Drop Table M6UF4_CICLE;
        Drop Table M6UF4_FAMILIACICLE;
         
         
         */
        

        /**
         * DROP TABLE M6UF2_Adreca; DROP TABLE M6UF2_POLISSA; DROP TABLE
         * M6UF2_USUARI; DROP TABLE VEHICLES; DROP TABLE M6UF2_CLIENT; DROP
         * TABLE M6UF2_Asseguradora;
         */
        Alumne_control ac = new Alumne_control();
        Cicle_control c = new Cicle_control();
        Curs_control cur = new Curs_control();
        FamiliaCicle_control fam = new FamiliaCicle_control();
        Import_control i = new Import_control();
        Matricula_control m = new Matricula_control();
        Modul_control mo = new Modul_control();
        UnitatFormativa_control uff = new UnitatFormativa_control();

        Calendar c1 = new GregorianCalendar(2017, 05, 02);

        Alumne al = new Alumne("71238085E", "joanaa", "vil", "joana@gmail.com", 671576288);
        Cicle cicle = new Cicle(1L, "DAM", 1);
        Curs curs = new Curs(1L, "2nd");
        FamiliaCicle f = new FamiliaCicle(1L, "Informatica");

        Matricula mat = new Matricula(1L, al, c1, true, true);
        Import imp = new Import(1L, 380, mat);

        Modul mod = new Modul(1L, "M1");
        UnitatFormativa uf = new UnitatFormativa(1L, "UF1", "80H");

//        //ac.Afegir(al);
//        
//        
//        ac.imprimirAlumne(ac.buscarPorNombre("joanaa"));
//        //ac.modificar(al);
//        ac.eliminar(al);


        ac.Afegir(al);
        c.Afegir(cicle);
        cur.Afegir(curs);
        fam.Afegir(f);
        m.Afegir(mat);
        i.Afegir(imp);
        mo.Afegir(mod);
        uff.Afegir(uf);

    }

}
