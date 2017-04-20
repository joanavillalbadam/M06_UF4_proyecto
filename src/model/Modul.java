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
public class Modul implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idModul;
    
    @Column(name = "nomModul")
    String nomModul;
    
    //
    List<UnitatFormativa> listaUnitatModul = new ArrayList<>();

    public Modul() {
    }

    public Modul(Long idModul, String nomModul) {
        this.idModul = idModul;
        this.nomModul = nomModul;
    }

    public String getNomModul() {
        return nomModul;
    }

    public void setNomModul(String nomModul) {
        this.nomModul = nomModul;
    }

    public List<UnitatFormativa> getListaUnitatModul() {
        return listaUnitatModul;
    }

    public void setListaUnitatModul(List<UnitatFormativa> listaUnitatModul) {
        this.listaUnitatModul = listaUnitatModul;
    }

    
    public Long getIdModul() {
        return idModul;
    }

    public void setIdModul(Long idModul) {
        this.idModul = idModul;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idModul != null ? idModul.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the idModul fields are not set
        if (!(object instanceof Modul)) {
            return false;
        }
        Modul other = (Modul) object;
        if ((this.idModul == null && other.idModul != null) || (this.idModul != null && !this.idModul.equals(other.idModul))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modul{" + "idModul=" + idModul + ", nomModul=" + nomModul + ", listaUnitatModul=" + listaUnitatModul + '}';
    }

}
