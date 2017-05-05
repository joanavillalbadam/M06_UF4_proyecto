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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author ALUMNEDAM
 */
@Entity
//El query para buscar el UnitatFormativa por el nombre
@NamedQueries({
    @NamedQuery(name = UnitatFormativa.CONSULTA, query = "SELECT uf FROM UnitatFormativa uf WHERE uf.nomUnitat=:nombre")})
@Table(name = "M6UF4_UnitatFormativa") //Nombre de la tabla en base de dato.
public class UnitatFormativa implements Serializable {
    
    
    //nombre de la consulta
    public static final String CONSULTA = "nomUnitat";

    //id de uf
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id_UF", nullable = false, unique = true)
    private Long idUnitat;
      
    //Nombre de uf
    @Column(name = "nomUnitat")
    String nomUnitat;
    
    //Horas que contiene ese uf
    @Column(name = "horas")
    String horas;
    
    //Relacion de muchos a uno con el curs
    @ManyToOne
    @JoinColumn(name = "Curs_UF")
    private Curs cursUF;

    //Relacion de muchos a uno con el modulo
    @ManyToOne
    @JoinColumn(name = "Modulo_UF")
    private Modul modulUF;
    
    
    //Relacion de muchos a uno con la tabla matricula
    @ManyToOne
    @JoinColumn(name = "Matricula_UF")
    private Matricula matricula;
     
    
    /**
     * Constructor vacio
     */
    public UnitatFormativa() {
    }

    /**
     * Constructor
     * @param idUnitat
     * @param nomUnitat
     * @param horas 
     */
    public UnitatFormativa(Long idUnitat, String nomUnitat, String horas) {
        this.idUnitat = idUnitat;
        this.nomUnitat = nomUnitat;
        this.horas = horas;
    }

    
    //Getter y setters, y los methodos por defecto de entitat
    
    
    public Curs getCursUF() {
        return cursUF;
    }

    public void setCursUF(Curs cursUF) {
        this.cursUF = cursUF;
    }

    public Modul getModulUF() {
        return modulUF;
    }

    public void setModulUF(Modul modulUF) {
        this.modulUF = modulUF;
    }

    public Matricula getMatricula() {
        return matricula;
    }

    public void setMatricula(Matricula matricula) {
        this.matricula = matricula;
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
        return "UnitatFormativa{" + "idUnitat=" + idUnitat + ", nomUnitat=" + nomUnitat + ", horas=" + horas + ", cursUF=" + cursUF + ", modulUF=" + modulUF + ", matricula=" + matricula + '}';
    }

    

    

    
}
