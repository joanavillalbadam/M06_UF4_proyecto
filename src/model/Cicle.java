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
//El query para buscar el cicle por el nombre
@NamedQueries({
    @NamedQuery(name = Cicle.CONSULTA, query = "SELECT c FROM Cicle c WHERE c.nombreCicle=:nombre")})
@Table(name = "M6UF4_Cicle") //Nombre de la tabla en base de dato.

public class Cicle implements Serializable {

    //nombre de la consulta
    public static final String CONSULTA = "nomCicle";
    
    //El id de cicle
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id_Cicle", nullable = false, unique = true)
    private Long idCicle;

    //Columna de nombre de cicle
    @Column(name = "nombre_Cicle", nullable = false)
    private String nombreCicle;
    
    //El grado
    @Column(name = "grau", nullable = false)
    private int grau;
    
    //Relacion de muchos a uno, con familia cicle.
    @ManyToOne
    @JoinColumn(name = "familia_cicle")
    private FamiliaCicle cicleF;
    
    
    //Relacion de uno a muchos, con la lista de modulos
    @OneToMany(fetch = FetchType.EAGER,mappedBy="cicleM")
    @Fetch(value = FetchMode.SUBSELECT)
    List<Modul> listaModul;
    
    
    //Relacion uno a mucho con la lista de cursos.
    @OneToMany(fetch = FetchType.EAGER, mappedBy="cicleC")
    @Fetch(value = FetchMode.SUBSELECT)
    List<Curs> listaCurs;

    /**
     * Constructor vacio
     */
    public Cicle() {
    }

    /**
     * Constructor
     * @param idCicle
     * @param nombreCicle
     * @param grau 
     */
    public Cicle(Long idCicle, String nombreCicle, int grau) {
        this.idCicle = idCicle;
        this.nombreCicle = nombreCicle;
        this.grau = grau;
        this.listaCurs = new ArrayList<>();
        this.listaModul = new ArrayList<>();
        
    }

    
    //Getter y setters, y los methodos por defecto de entitat
    
    public FamiliaCicle getCicleF() {
        return cicleF;
    }

    public void setCicleF(FamiliaCicle cicleF) {
        this.cicleF = cicleF;
    }

    public String getNombreCicle() {
        return nombreCicle;
    }

    public void setNombreCicle(String nombreCicle) {
        this.nombreCicle = nombreCicle;
    }

    public int getGrau() {
        return grau;
    }

    public void setGrau(int grau) {
        this.grau = grau;
    }

    public List<Modul> getListaModul() {
        return listaModul;
    }

    public void setListaModul(List<Modul> listaModul) {
        this.listaModul = listaModul;
    }

    public List<Curs> getListaCurs() {
        return listaCurs;
    }

    public void setListaCurs(List<Curs> listaCurs) {
        this.listaCurs = listaCurs;
    }
    
    public Long getIdCicle() {
        return idCicle;
    }

    public void setIdCicle(Long idCicle) {
        this.idCicle = idCicle;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCicle != null ? idCicle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the idCicle fields are not set
        if (!(object instanceof Cicle)) {
            return false;
        }
        Cicle other = (Cicle) object;
        if ((this.idCicle == null && other.idCicle != null) || (this.idCicle != null && !this.idCicle.equals(other.idCicle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Cicle{" + "idCicle=" + idCicle + ", nombreCicle=" + nombreCicle + ", grau=" + grau + ", cicleF=" + cicleF + ", listaModul=" + listaModul + ", listaCurs=" + listaCurs + '}';
    }

    

    
}
