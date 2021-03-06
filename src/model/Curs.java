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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
//El query para buscar el curso por el su id.
@NamedQueries({
    @NamedQuery(name = Curs.CONSULTA, query = "SELECT curs FROM Curs curs WHERE curs.idCurso=:id")})
@Table(name = "M6UF4_Curs") //Nombre de la tabla en base de dato.

public class Curs implements Serializable {

    //nombre de la consulta
    private static final long serialVersionUID = 1L;
    
    //Id de curso
    public static final String CONSULTA = "idCurs";
    @Id
    @Column(name = "id_Curs", nullable = false, unique = true)
    private Long idCurso;
    
    //El ano de curos si es primero o segundo
    @Column(name = "curso")
    String primSegun;
    
    //Relacion de muchos a uno con el ciclo
    @ManyToOne
    @JoinColumn(name = "cicle_curs")
    private Cicle cicleC;
    
    //Relacion de uno a mucho con la lista de unitat formativa
    @OneToMany(fetch = FetchType.EAGER, mappedBy="cursUF")
    @Fetch(value = FetchMode.SUBSELECT)
    List<UnitatFormativa> listaUnitatCurs;

    
    /**
     * Constructor vacio
     */
    public Curs() {
    }

    /**
     * Constructor 
     * @param idCurso
     * @param primSegun 
     */
    public Curs(Long idCurso, String primSegun) {
        this.idCurso = idCurso;
        this.primSegun = primSegun;
        this.listaUnitatCurs = new ArrayList<>();
    }

    
    //Getter y setters, y los methodos por defecto de entitat
    
    public Cicle getCicleC() {
        return cicleC;
    }

    public void setCicleC(Cicle cicleC) {
        this.cicleC = cicleC;
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
        return "Curs{" + "idCurso=" + idCurso + ", primSegun=" + primSegun + ", cicleC=" + cicleC + ", listaUnitatCurs=" + listaUnitatCurs + '}';
    }

    

    

}
