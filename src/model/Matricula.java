/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.persistence.CascadeType;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 *
 * @author ALUMNEDAM
 */
@Entity
//El query para buscar el matricula por su id.
@NamedQueries({
    @NamedQuery(name = Matricula.CONSULTA, query = "SELECT m FROM Matricula m WHERE m.idMatricula=:id")})
@Table(name = "M6UF4_Matricula") //Nombre de la tabla en base de dato.
public class Matricula implements Serializable {

    //nombre de la consulta
    public static final String CONSULTA = "idMAtricula";

    //Id de matricula
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id_Matricula", nullable = false, unique = true)
    private Long idMatricula;

    //Columna de opbjeto alumno
    @Column(name = "alumne", nullable = false)
    private Alumne alumne;
    
    //Columna de fecha de matricula
    @Column(name = "dataMatricula", nullable = false)
    private String dataMatricula;

    //Relacion de uno a muchos con la lista de unitat formativa
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "matricula")
    @Fetch(value = FetchMode.SUBSELECT)
    List<UnitatFormativa> unitatFormativa;

    //Relacion de uno a uno con el import
    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "import_matricula")
    private Import importe;

    //Si es true sera cursoCompleto y si es false seran uf sueltas
    @Column(name = "modalitat", nullable = false)
    private boolean modalitat;
    
    
    //true 50 false 100
    @Column(name = "descuentos", nullable = false)
    private boolean descuentos;

    /**
     * Constructor vacio
     */
    public Matricula() {
    }

    /**
     * Constructor 
     * @param idMatricula
     * @param alumne
     * @param dataMatricula
     * @param modalitat
     * @param descuentos 
     */
    public Matricula(Long idMatricula, Alumne alumne, String dataMatricula, boolean modalitat, boolean descuentos) {
        this.idMatricula = idMatricula;
        this.alumne = alumne;
        this.dataMatricula = dataMatricula;
        this.modalitat = modalitat;
        this.descuentos = descuentos;
        this.unitatFormativa = new ArrayList<>();
    }

    
    //Getter y setters, y los methodos por defecto de entitat
    
    
    public Import getImporte() {
        return importe;
    }

    public void setImporte(Import importe) {
        this.importe = importe;
    }

    public Alumne getAlumne() {
        return alumne;
    }

    public void setAlumne(Alumne alumne) {
        this.alumne = alumne;
    }

    public String getDataMatricula() {
        return dataMatricula;
    }

    public void setDataMatricula(String dataMatricula) {
        this.dataMatricula = dataMatricula;
    }

    

    public List<UnitatFormativa> getUnitatFormativa() {
        return unitatFormativa;
    }

    public void setUnitatFormativa(List<UnitatFormativa> unitatFormativa) {
        this.unitatFormativa = unitatFormativa;
    }

    public boolean isModalitat() {
        return modalitat;
    }

    public void setModalitat(boolean modalitat) {
        this.modalitat = modalitat;
    }

    public boolean isDescuentos() {
        return descuentos;
    }

    public void setDescuentos(boolean descuentos) {
        this.descuentos = descuentos;
    }

    public Long getIdMatricula() {
        return idMatricula;
    }

    public void setIdMatricula(Long idMatricula) {
        this.idMatricula = idMatricula;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMatricula != null ? idMatricula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the idMatricula fields are not set
        if (!(object instanceof Matricula)) {
            return false;
        }
        Matricula other = (Matricula) object;
        if ((this.idMatricula == null && other.idMatricula != null) || (this.idMatricula != null && !this.idMatricula.equals(other.idMatricula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Matricula{" + "idMatricula=" + idMatricula + ", alumne=" + alumne + ", dataMatricula=" + dataMatricula + ", unitatFormativa=" + unitatFormativa + ", importe=" + importe + ", modalitat=" + modalitat + ", descuentos=" + descuentos + '}';
    }

    

    

    

}
