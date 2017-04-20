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
public class FamiliaCicle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idFamilia;
    
    @Column(name = "nombre_Familia", nullable = false)
    private String nombreFamilia;
    
    
    //TODO: hacer la referencia a la clase cicle
    List<Cicle> cicle = new ArrayList<>();

    public FamiliaCicle() {
    }

    public FamiliaCicle(Long idFamilia, String nombreFamilia) {
        this.idFamilia = idFamilia;
        this.nombreFamilia = nombreFamilia;
    }

    public String getNombreFamilia() {
        return nombreFamilia;
    }

    public void setNombreFamilia(String nombreFamilia) {
        this.nombreFamilia = nombreFamilia;
    }

    public List<Cicle> getCicle() {
        return cicle;
    }

    public void setCicle(List<Cicle> cicle) {
        this.cicle = cicle;
    }
    
    public Long getIdFamilia() {
        return idFamilia;
    }

    public void setIdFamilia(Long idFamilia) {
        this.idFamilia = idFamilia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFamilia != null ? idFamilia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the idFamilia fields are not set
        if (!(object instanceof FamiliaCicle)) {
            return false;
        }
        FamiliaCicle other = (FamiliaCicle) object;
        if ((this.idFamilia == null && other.idFamilia != null) || (this.idFamilia != null && !this.idFamilia.equals(other.idFamilia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "FamiliaCicle{" + "idFamilia=" + idFamilia + ", nombreFamilia=" + nombreFamilia + ", cicle=" + cicle + '}';
    }
    
}
