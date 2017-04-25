/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author ALUMNEDAM
 */
@Entity
@NamedQueries({
    @NamedQuery(name = Alumne.CONSULTA, query = "SELECT a FROM Alumne a WHERE a.nombreAlum=:nombre")})
@Table(name = "M6UF4_Alumne")

public class Alumne implements Serializable {

    public static final String CONSULTA = "nomAlum";
    
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "nif", length = 9, nullable = false, unique = true)
    private String nif;
   
    
    

    @Column(name = "nombre_alum", nullable = false)
    private String nombreAlum;
    
    @Column(name = "cognom_alum")
    private String cognomAlum;
    
    @Column(name = "correo", length = 25, nullable = false, unique = true)
    private String correo;
    
    @Column(name = "telefono", length = 9, nullable = false)
    private int telefono;

    public Alumne() {
    }

    public Alumne(String nif, String nombreAlum, String cognomAlum, String correo, int telefono) {
        this.nif = nif;
        this.nombreAlum = nombreAlum;
        this.cognomAlum = cognomAlum;
        this.correo = correo;
        this.telefono = telefono;
    }

    

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
