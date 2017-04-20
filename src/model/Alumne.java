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

/**
 *
 * @author ALUMNEDAM
 */
@Entity
public class Alumne implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
   
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

    public Alumne(Long id, String nif, String nombreAlum, String cognomAlum, String correo, int telefono) {
        this.id = id;
        this.nif = nif;
        this.nombreAlum = nombreAlum;
        this.cognomAlum = cognomAlum;
        this.correo = correo;
        this.telefono = telefono;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
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
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Alumne)) {
            return false;
        }
        Alumne other = (Alumne) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Alummne{" + "id=" + id + ", nif=" + nif + ", nombreAlum=" + nombreAlum + ", cognomAlum=" + cognomAlum + ", correo=" + correo + ", telefono=" + telefono + '}';
    }

}
