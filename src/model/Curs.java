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
public class Curs implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idCurso;
    
    @Column(name = "curso")
    String primSegun;
    
    
    //
    List<UnitatFormativa> listaUnitatCurs = new ArrayList<>();

    public Curs() {
    }

    public Curs(Long idCurso, String primSegun) {
        this.idCurso = idCurso;
        this.primSegun = primSegun;
    }

    public String getPrimSegun() {
        return primSegun;
    }

    public void setPrimSegun(String primSegun) {
        this.primSegun = primSegun;
    }

    public List<UnitatFormativa> getListaUnitatCurs() {
        return listaUnitatCurs;
    }

    public void setListaUnitatCurs(List<UnitatFormativa> listaUnitatCurs) {
        this.listaUnitatCurs = listaUnitatCurs;
    }

    
    
    public Long getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Long idCurso) {
        this.idCurso = idCurso;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCurso != null ? idCurso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the idCurso fields are not set
        if (!(object instanceof Curs)) {
            return false;
        }
        Curs other = (Curs) object;
        if ((this.idCurso == null && other.idCurso != null) || (this.idCurso != null && !this.idCurso.equals(other.idCurso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Curs{" + "idCurso=" + idCurso + ", primSegun=" + primSegun + ", listaUnitatCurs=" + listaUnitatCurs + '}';
    }

}
