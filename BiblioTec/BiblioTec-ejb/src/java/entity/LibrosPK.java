/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author cobrakik
 */
@Embeddable
public class LibrosPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id")
    private int id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "autor_id")
    private int autorId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "editorial_id")
    private int editorialId;

    public LibrosPK() {
    }

    public LibrosPK(int id, int autorId, int editorialId) {
        this.id = id;
        this.autorId = autorId;
        this.editorialId = editorialId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAutorId() {
        return autorId;
    }

    public void setAutorId(int autorId) {
        this.autorId = autorId;
    }

    public int getEditorialId() {
        return editorialId;
    }

    public void setEditorialId(int editorialId) {
        this.editorialId = editorialId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        hash += (int) autorId;
        hash += (int) editorialId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LibrosPK)) {
            return false;
        }
        LibrosPK other = (LibrosPK) object;
        if (this.id != other.id) {
            return false;
        }
        if (this.autorId != other.autorId) {
            return false;
        }
        if (this.editorialId != other.editorialId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.LibrosPK[ id=" + id + ", autorId=" + autorId + ", editorialId=" + editorialId + " ]";
    }
    
}
