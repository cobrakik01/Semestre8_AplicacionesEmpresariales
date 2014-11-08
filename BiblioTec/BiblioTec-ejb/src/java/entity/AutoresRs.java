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
import javax.persistence.FetchType;
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
@Table(name = "autores_rs", catalog = "bibliotec", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AutoresRs.findAll", query = "SELECT a FROM AutoresRs a"),
    @NamedQuery(name = "AutoresRs.findById", query = "SELECT a FROM AutoresRs a WHERE a.autoresRsPK.id = :id"),
    @NamedQuery(name = "AutoresRs.findByAutorId", query = "SELECT a FROM AutoresRs a WHERE a.autoresRsPK.autorId = :autorId"),
    @NamedQuery(name = "AutoresRs.findByRedSocialId", query = "SELECT a FROM AutoresRs a WHERE a.autoresRsPK.redSocialId = :redSocialId"),
    @NamedQuery(name = "AutoresRs.findByDireccion", query = "SELECT a FROM AutoresRs a WHERE a.direccion = :direccion")})
public class AutoresRs implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AutoresRsPK autoresRsPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "direccion")
    private String direccion;
    @JoinColumn(name = "autor_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Autores autores;
    @JoinColumn(name = "red_social_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private RedesSociales redesSociales;

    public AutoresRs() {
    }

    public AutoresRs(AutoresRsPK autoresRsPK) {
        this.autoresRsPK = autoresRsPK;
    }

    public AutoresRs(AutoresRsPK autoresRsPK, String direccion) {
        this.autoresRsPK = autoresRsPK;
        this.direccion = direccion;
    }

    public AutoresRs(int id, int autorId, int redSocialId) {
        this.autoresRsPK = new AutoresRsPK(id, autorId, redSocialId);
    }

    public AutoresRsPK getAutoresRsPK() {
        return autoresRsPK;
    }

    public void setAutoresRsPK(AutoresRsPK autoresRsPK) {
        this.autoresRsPK = autoresRsPK;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Autores getAutores() {
        return autores;
    }

    public void setAutores(Autores autores) {
        this.autores = autores;
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
        hash += (autoresRsPK != null ? autoresRsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AutoresRs)) {
            return false;
        }
        AutoresRs other = (AutoresRs) object;
        if ((this.autoresRsPK == null && other.autoresRsPK != null) || (this.autoresRsPK != null && !this.autoresRsPK.equals(other.autoresRsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.AutoresRs[ autoresRsPK=" + autoresRsPK + " ]";
    }
    
}
