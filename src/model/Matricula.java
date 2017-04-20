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
public class Matricula implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idMatricula;

    
    private Alumne alumne;
    private Calendar dataMatricula;
    List<Cicle> cicle = new ArrayList<>();
    //Si es true sera cursoCompleto y si es false seran uf sueltas
    private boolean modalitat; 
    //true 50 false 100
    private boolean descuentos;

    public Matricula() {
    }

    public Matricula(Long idMatricula, Alumne alumne, Calendar dataMatricula, boolean modalitat, boolean descuentos) {
        this.idMatricula = idMatricula;
        this.alumne = alumne;
        this.dataMatricula = dataMatricula;
        this.modalitat = modalitat;
        this.descuentos = descuentos;
    }

    public Alumne getAlumne() {
        return alumne;
    }

    public void setAlumne(Alumne alumne) {
        this.alumne = alumne;
    }

    public Calendar getDataMatricula() {
        return dataMatricula;
    }

    public void setDataMatricula(Calendar dataMatricula) {
        this.dataMatricula = dataMatricula;
    }

    public List<Cicle> getCicle() {
        return cicle;
    }

    public void setCicle(List<Cicle> cicle) {
        this.cicle = cicle;
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
        return "Matricula{" + "idMatricula=" + idMatricula + ", alumne=" + alumne + ", dataMatricula=" + dataMatricula + ", cicle=" + cicle + ", modalitat=" + modalitat + ", descuentos=" + descuentos + '}';
    }


    
}
