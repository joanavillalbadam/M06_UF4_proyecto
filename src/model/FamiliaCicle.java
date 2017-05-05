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
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 *
 * @author ALUMNEDAM
 */
@Entity
//El query para buscar el Damilia de ciclo por el nombre
@NamedQueries({
    @NamedQuery(name = FamiliaCicle.CONSULTA, query = "SELECT fam FROM FamiliaCicle fam WHERE fam.nombreFamilia=:nombre")})
@Table(name = "M6UF4_FamiliaCicle") //Nombre de la tabla en base de dato.
public class FamiliaCicle implements Serializable {

    //nombre de la consulta
    public static final String CONSULTA = "nomFamilia";
    
    //id de familia de ciclo.
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id_Familia", nullable = false, unique = true)
    private Long idFamilia;
    
    //Columna de nombre de familia
    @Column(name = "nombre_Familia", nullable = false)
    private String nombreFamilia;
    
    
    //TODO: hacer la referencia a la clase cicle
    //Relacion de uno a mucho con la lista de cicle
    @OneToMany(fetch = FetchType.EAGER, mappedBy="cicleF")
    @Fetch(value = FetchMode.SUBSELECT)
    List<Cicle> cicle;

    /**
     * Constructor vacio
     */
    public FamiliaCicle() {
    }

    /**
     * Constructor
     * @param idFamilia
     * @param nombreFamilia 
     */
    public FamiliaCicle(Long idFamilia, String nombreFamilia) {
        this.idFamilia = idFamilia;
        this.nombreFamilia = nombreFamilia;
        this.cicle = new ArrayList<>();
    }
    
    //Getter y setters, y los methodos por defecto de entitat

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
