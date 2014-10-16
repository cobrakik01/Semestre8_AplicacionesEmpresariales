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
public class AutoresRsPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id")
    private int id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "autor_id")
    private int autorId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "red_social_id")
    private int redSocialId;

    public AutoresRsPK() {
    }

    public AutoresRsPK(int id, int autorId, int redSocialId) {
        this.id = id;
        this.autorId = autorId;
        this.redSocialId = redSocialId;
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
        hash += (int) autorId;
        hash += (int) redSocialId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AutoresRsPK)) {
            return false;
        }
        AutoresRsPK other = (AutoresRsPK) object;
        if (this.id != other.id) {
            return false;
        }
        if (this.autorId != other.autorId) {
            return false;
        }
        if (this.redSocialId != other.redSocialId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.AutoresRsPK[ id=" + id + ", autorId=" + autorId + ", redSocialId=" + redSocialId + " ]";
    }
    
}
