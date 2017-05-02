/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author ALUMNEDAM
 */
@Entity
@NamedQueries({
    @NamedQuery(name = Import.CONSULTA, query = "SELECT i FROM Import i WHERE i.idImport=:id")})
@Table(name = "M6UF4_Import")
public class Import implements Serializable {

    
    public static final String CONSULTA = "idImport";
    
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id_Import", nullable = false, unique = true)
    private Long idImport;
    
    @Column(name = "import", nullable = false)
    private double importe;
    
    @OneToOne(mappedBy = "importe")
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
