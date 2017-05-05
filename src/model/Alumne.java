/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author ALUMNEDAM
 */
@Entity
//EL querie para buscar un alumne desde su nombre
@NamedQueries({
    @NamedQuery(name = Alumne.CONSULTA, query = "SELECT a FROM Alumne a WHERE a.nombreAlum=:nombre")})
@Table(name = "M6UF4_Alumne")//Nombre de tabla

public class Alumne implements Serializable {

    //Nombre de la consulta
    public static final String CONSULTA = "nomAlumne";
    
    //Id de alumno, que sera su nif
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "nif", length = 9, nullable = false, unique = true)
    private String nif;
   
    //Columna de nombre de alumno
    @Column(name = "nombre_alum", nullable = false)
    private String nombreAlum;
    
    //Apellido de alumno
    @Column(name = "cognom_alum")
    private String cognomAlum;
    
    //SU correo electronico
    @Column(name = "correo", length = 25, nullable = false, unique = true)
    private String correo;
    
    //El telefono de alumno
    @Column(name = "telefono", length = 9, nullable = false)
    private int telefono;

    /**
     * Constructor vacio
     */
    public Alumne() {
    }

    /**
     * Constructo para iniciar datos
     * @param nif
     * @param nombreAlum
     * @param cognomAlum
     * @param correo
     * @param telefono 
     */
    public Alumne(String nif, String nombreAlum, String cognomAlum, String correo, int telefono) {
        this.nif = nif;
        this.nombreAlum = nombreAlum;
        this.cognomAlum = cognomAlum;
        this.correo = correo;
        this.telefono = telefono;
    }

    //Getter y setters, y los methodos por defecto de entitat

    public String getNombreAlum() {
        return nombreAlum;
    }

    public void setNombreAlum(String nombreAlum) {
        this.nombreAlum = nombreAlum;
    }

    public String getCognomAlum() {
        return cognomAlum;
    }

    public void setCognomAlum(String cognomAlum) {
        this.cognomAlum = cognomAlum;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
    
    
    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nif != null ? nif.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the nif fields are not set
        if (!(object instanceof Alumne)) {
            return false;
        }
        Alumne other = (Alumne) object;
        if ((this.nif == null && other.nif != null) || (this.nif != null && !this.nif.equals(other.nif))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Alumne{" + "nif=" + nif + ", nombreAlum=" + nombreAlum + ", cognomAlum=" + cognomAlum + ", correo=" + correo + ", telefono=" + telefono + '}';
    }

   
    

}
