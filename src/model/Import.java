/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author ALUMNEDAM
 */
@Entity
public class Import implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idImport;
    
    private double importe;
    private Matricula matricula;

    public Import() {
    }

    public Import(Long idImport, double importe, Matricula matricula) {
        this.idImport = idImport;
        this.importe = importe;
        this.matricula = matricula;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public Matricula getMatricula() {
        return matricula;
    }

    public void setMatricula(Matricula matricula) {
        this.matricula = matricula;
    }
    

    public Long getIdImport() {
        return idImport;
    }

    public void setIdImport(Long idImport) {
        this.idImport = idImport;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idImport != null ? idImport.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the idImport fields are not set
        if (!(object instanceof Import)) {
            return false;
        }
        Import other = (Import) object;
        if ((this.idImport == null && other.idImport != null) || (this.idImport != null && !this.idImport.equals(other.idImport))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Import{" + "idImport=" + idImport + ", importe=" + importe + ", matricula=" + matricula + '}';
    }
    
}
