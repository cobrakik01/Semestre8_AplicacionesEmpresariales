/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author cobrakik
 */
@Entity
@Table(name = "temas", catalog = "bibliotec", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Temas.findAll", query = "SELECT t FROM Temas t"),
    @NamedQuery(name = "Temas.findById", query = "SELECT t FROM Temas t WHERE t.id = :id"),
    @NamedQuery(name = "Temas.findByTemas", query = "SELECT t FROM Temas t WHERE t.temas = :temas"),
    @NamedQuery(name = "Temas.findByNombre", query = "SELECT t FROM Temas t WHERE t.nombre = :nombre"),
    @NamedQuery(name = "Temas.findByNoPagina", query = "SELECT t FROM Temas t WHERE t.noPagina = :noPagina")})
public class Temas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "temas")
    private String temas;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "no_pagina")
    private int noPagina;
    @JoinColumns({
        @JoinColumn(name = "libros_id", referencedColumnName = "id"),
        @JoinColumn(name = "libros_autor_id", referencedColumnName = "autor_id"),
        @JoinColumn(name = "libros_editorial_id", referencedColumnName = "editorial_id")})
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Libros libros;
    @JoinColumn(name = "tipos_temas_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TiposTemas tiposTemasId;

    public Temas() {
    }

    public Temas(Integer id) {
        this.id = id;
    }

    public Temas(Integer id, String temas, String nombre, int noPagina) {
        this.id = id;
        this.temas = temas;
        this.nombre = nombre;
        this.noPagina = noPagina;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTemas() {
        return temas;
    }

    public void setTemas(String temas) {
        this.temas = temas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNoPagina() {
        return noPagina;
    }

    public void setNoPagina(int noPagina) {
        this.noPagina = noPagina;
    }

    public Libros getLibros() {
        return libros;
    }

    public void setLibros(Libros libros) {
        this.libros = libros;
    }

    public TiposTemas getTiposTemasId() {
        return tiposTemasId;
    }

    public void setTiposTemasId(TiposTemas tiposTemasId) {
        this.tiposTemasId = tiposTemasId;
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
        if (!(object instanceof Temas)) {
            return false;
        }
        Temas other = (Temas) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Temas[ id=" + id + " ]";
    }
    
}
