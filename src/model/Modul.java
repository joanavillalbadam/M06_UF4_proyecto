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
//El query para buscar el modul por el nombre
@NamedQueries({
    @NamedQuery(name = Modul.CONSULTA, query = "SELECT m FROM Modul m WHERE m.nomModul=:nombre")})
@Table(name = "M6UF4_Modul") //Nombre de la tabla en base de dato.

public class Modul implements Serializable {
    
    //nombre de la consulta
    public static final String CONSULTA = "nomModul";

    //id de modulo
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id_Modul", nullable = false, unique = true)
    private Long idModul;
    
    //Columna de nombre de modulo
    @Column(name = "nomModul")
    String nomModul;
    
    //Relacion de muchos a uno con el cicle
    @ManyToOne
    @JoinColumn(name = "cicle_modul")
    private Cicle cicleM;
    
    
    //Relacion de uno a mucho con la lista de unitatformativa
    @OneToMany(fetch = FetchType.EAGER, mappedBy="modulUF")
    @Fetch(value = FetchMode.SUBSELECT)
    List<UnitatFormativa> listaUnitatModul;

    /**
     * Constructor vacio
     */
    public Modul() {
    }

    /**
     * Constructor
     * @param idModul
     * @param nomModul 
     */
    public Modul(Long idModul, String nomModul) {
        this.idModul = idModul;
        this.nomModul = nomModul;
        this.listaUnitatModul = new ArrayList<>();
    }

    
    //Getter y setters, y los methodos por defecto de entitat
    
    
    public Cicle getCicleM() {
        return cicleM;
    }

    public void setCicleM(Cicle cicleM) {
        this.cicleM = cicleM;
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
        return "Modul{" + "idModul=" + idModul + ", nomModul=" + nomModul + ", cicleM=" + cicleM + ", listaUnitatModul=" + listaUnitatModul + '}';
    }

    

    

}
