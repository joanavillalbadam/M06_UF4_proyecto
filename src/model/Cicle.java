/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author ALUMNEDAM
 */
@Entity
public class Cicle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idCicle;

    @Column(name = "nombre_Cicle", nullable = false)
    private String nombreCicle;
    
    @Column(name = "grau", nullable = false)
    private int grau;
    
    //
    List<Modul> listaModul = new ArrayList<>();
    
    //
    List<Curs> listaCurs = new ArrayList<>();

    public Cicle() {
    }

    public Cicle(Long idCicle, String nombreCicle, int grau) {
        this.idCicle = idCicle;
        this.nombreCicle = nombreCicle;
        this.grau = grau;
    }

    public String getNombreCicle() {
        return nombreCicle;
    }

    public void setNombreCicle(String nombreCicle) {
        this.nombreCicle = nombreCicle;
    }

    public int getGrau() {
        return grau;
    }

    public void setGrau(int grau) {
        this.grau = grau;
    }

    public List<Modul> getListaModul() {
        return listaModul;
    }

    public void setListaModul(List<Modul> listaModul) {
        this.listaModul = listaModul;
    }

    public List<Curs> getListaCurs() {
        return listaCurs;
    }

    public void setListaCurs(List<Curs> listaCurs) {
        this.listaCurs = listaCurs;
    }
    
    public Long getIdCicle() {
        return idCicle;
    }

    public void setIdCicle(Long idCicle) {
        this.idCicle = idCicle;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCicle != null ? idCicle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the idCicle fields are not set
        if (!(object instanceof Cicle)) {
            return false;
        }
        Cicle other = (Cicle) object;
        if ((this.idCicle == null && other.idCicle != null) || (this.idCicle != null && !this.idCicle.equals(other.idCicle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Cicle{" + "idCicle=" + idCicle + ", nombreCicle=" + nombreCicle + ", grau=" + grau + ", listaModul=" + listaModul + ", listaCurs=" + listaCurs + '}';
    }
    
}
