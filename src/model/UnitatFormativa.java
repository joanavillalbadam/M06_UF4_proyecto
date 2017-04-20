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
public class UnitatFormativa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idUnitat;
      
    @Column(name = "nomUnitat")
    String nomUnitat;
    
    @Column(name = "horas")
    String horas;

    public UnitatFormativa() {
    }

    public UnitatFormativa(Long idUnitat, String nomUnitat, String horas) {
        this.idUnitat = idUnitat;
        this.nomUnitat = nomUnitat;
        this.horas = horas;
    }

    public String getNomUnitat() {
        return nomUnitat;
    }

    public void setNomUnitat(String nomUnitat) {
        this.nomUnitat = nomUnitat;
    }

    public String getHoras() {
        return horas;
    }

    public void setHoras(String horas) {
        this.horas = horas;
    }
    
    public Long getIdUnitat() {
        return idUnitat;
    }

    public void setIdUnitat(Long idUnitat) {
        this.idUnitat = idUnitat;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUnitat != null ? idUnitat.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the idUnitat fields are not set
        if (!(object instanceof UnitatFormativa)) {
            return false;
        }
        UnitatFormativa other = (UnitatFormativa) object;
        if ((this.idUnitat == null && other.idUnitat != null) || (this.idUnitat != null && !this.idUnitat.equals(other.idUnitat))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "UnitatFormativa{" + "idUnitat=" + idUnitat + ", nomUnitat=" + nomUnitat + ", horas=" + horas + '}';
    }

    
}
