/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author cobrakik
 */
@Entity
@Table(name = "libros", catalog = "bibliotec", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Libros.findAll", query = "SELECT l FROM Libros l"),
    @NamedQuery(name = "Libros.findById", query = "SELECT l FROM Libros l WHERE l.librosPK.id = :id"),
    @NamedQuery(name = "Libros.findByAutorId", query = "SELECT l FROM Libros l WHERE l.librosPK.autorId = :autorId"),
    @NamedQuery(name = "Libros.findByEditorialId", query = "SELECT l FROM Libros l WHERE l.librosPK.editorialId = :editorialId"),
    @NamedQuery(name = "Libros.findByNoPaginas", query = "SELECT l FROM Libros l WHERE l.noPaginas = :noPaginas"),
    @NamedQuery(name = "Libros.findByIsbn", query = "SELECT l FROM Libros l WHERE l.isbn = :isbn"),
    @NamedQuery(name = "Libros.findByTitulo", query = "SELECT l FROM Libros l WHERE l.titulo = :titulo"),
    @NamedQuery(name = "Libros.findByEdicion", query = "SELECT l FROM Libros l WHERE l.edicion = :edicion")})
public class Libros implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected LibrosPK librosPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "no_paginas")
    private int noPaginas;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "isbn")
    private String isbn;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "titulo")
    private String titulo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "edicion")
    private String edicion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "libros")
    private List<Prestamos> prestamosList;
    @JoinColumn(name = "autor_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Autores autores;
    @JoinColumn(name = "editorial_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Editoriales editoriales;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "libros")
    private List<Temas> temasList;

    public Libros() {
    }

    public Libros(LibrosPK librosPK) {
        this.librosPK = librosPK;
    }

    public Libros(LibrosPK librosPK, int noPaginas, String isbn, String titulo, String edicion) {
        this.librosPK = librosPK;
        this.noPaginas = noPaginas;
        this.isbn = isbn;
        this.titulo = titulo;
        this.edicion = edicion;
    }

    public Libros(int id, int autorId, int editorialId) {
        this.librosPK = new LibrosPK(id, autorId, editorialId);
    }

    public LibrosPK getLibrosPK() {
        return librosPK;
    }

    public void setLibrosPK(LibrosPK librosPK) {
        this.librosPK = librosPK;
    }

    public int getNoPaginas() {
        return noPaginas;
    }

    public void setNoPaginas(int noPaginas) {
        this.noPaginas = noPaginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEdicion() {
        return edicion;
    }

    public void setEdicion(String edicion) {
        this.edicion = edicion;
    }

    @XmlTransient
    public List<Prestamos> getPrestamosList() {
        return prestamosList;
    }

    public void setPrestamosList(List<Prestamos> prestamosList) {
        this.prestamosList = prestamosList;
    }

    public Autores getAutores() {
        return autores;
    }

    public void setAutores(Autores autores) {
        this.autores = autores;
    }

    public Editoriales getEditoriales() {
        return editoriales;
    }

    public void setEditoriales(Editoriales editoriales) {
        this.editoriales = editoriales;
    }

    @XmlTransient
    public List<Temas> getTemasList() {
        return temasList;
    }

    public void setTemasList(List<Temas> temasList) {
        this.temasList = temasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (librosPK != null ? librosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Libros)) {
            return false;
        }
        Libros other = (Libros) object;
        if ((this.librosPK == null && other.librosPK != null) || (this.librosPK != null && !this.librosPK.equals(other.librosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Libros[ librosPK=" + librosPK + " ]";
    }
    
}
