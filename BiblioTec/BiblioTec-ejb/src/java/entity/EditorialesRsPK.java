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
public class EditorialesRsPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id")
    private int id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "editorial_id")
    private int editorialId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "red_social_id")
    private int redSocialId;

    public EditorialesRsPK() {
    }

    public EditorialesRsPK(int id, int editorialId, int redSocialId) {
        this.id = id;
        this.editorialId = editorialId;
        this.redSocialId = redSocialId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEditorialId() {
        return editorialId;
    }

    public void setEditorialId(int editorialId) {
        this.editorialId = editorialId;
    }

    public int getRedSocialId() {
        return redSocialId;
    }

    public void setRedSocialId(int redSocialId) {
        this.redSocialId = redSocialId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        hash += (int) editorialId;
        hash += (int) redSocialId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EditorialesRsPK)) {
            return false;
        }
        EditorialesRsPK other = (EditorialesRsPK) object;
        if (this.id != other.id) {
            return false;
        }
        if (this.editorialId != other.editorialId) {
            return false;
        }
        if (this.redSocialId != other.redSocialId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.EditorialesRsPK[ id=" + id + ", editorialId=" + editorialId + ", redSocialId=" + redSocialId + " ]";
    }
    
}
