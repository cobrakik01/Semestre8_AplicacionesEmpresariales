/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
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
@Table(name = "editoriales_rs", catalog = "bibliotec", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EditorialesRs.findAll", query = "SELECT e FROM EditorialesRs e"),
    @NamedQuery(name = "EditorialesRs.findById", query = "SELECT e FROM EditorialesRs e WHERE e.editorialesRsPK.id = :id"),
    @NamedQuery(name = "EditorialesRs.findByEditorialId", query = "SELECT e FROM EditorialesRs e WHERE e.editorialesRsPK.editorialId = :editorialId"),
    @NamedQuery(name = "EditorialesRs.findByRedSocialId", query = "SELECT e FROM EditorialesRs e WHERE e.editorialesRsPK.redSocialId = :redSocialId"),
    @NamedQuery(name = "EditorialesRs.findByDireccion", query = "SELECT e FROM EditorialesRs e WHERE e.direccion = :direccion")})
public class EditorialesRs implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EditorialesRsPK editorialesRsPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "direccion")
    private String direccion;
    @JoinColumn(name = "editorial_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Editoriales editoriales;
    @JoinColumn(name = "red_social_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private RedesSociales redesSociales;

    public EditorialesRs() {
    }

    public EditorialesRs(EditorialesRsPK editorialesRsPK) {
        this.editorialesRsPK = editorialesRsPK;
    }

    public EditorialesRs(EditorialesRsPK editorialesRsPK, String direccion) {
        this.editorialesRsPK = editorialesRsPK;
        this.direccion = direccion;
    }

    public EditorialesRs(int id, int editorialId, int redSocialId) {
        this.editorialesRsPK = new EditorialesRsPK(id, editorialId, redSocialId);
    }

    public EditorialesRsPK getEditorialesRsPK() {
        return editorialesRsPK;
    }

    public void setEditorialesRsPK(EditorialesRsPK editorialesRsPK) {
        this.editorialesRsPK = editorialesRsPK;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Editoriales getEditoriales() {
        return editoriales;
    }

    public void setEditoriales(Editoriales editoriales) {
        this.editoriales = editoriales;
    }

    public RedesSociales getRedesSociales() {
        return redesSociales;
    }

    public void setRedesSociales(RedesSociales redesSociales) {
        this.redesSociales = redesSociales;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (editorialesRsPK != null ? editorialesRsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EditorialesRs)) {
            return false;
        }
        EditorialesRs other = (EditorialesRs) object;
        if ((this.editorialesRsPK == null && other.editorialesRsPK != null) || (this.editorialesRsPK != null && !this.editorialesRsPK.equals(other.editorialesRsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.EditorialesRs[ editorialesRsPK=" + editorialesRsPK + " ]";
    }
    
}
