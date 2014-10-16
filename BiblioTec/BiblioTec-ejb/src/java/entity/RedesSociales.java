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
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "redes_sociales", catalog = "bibliotec", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RedesSociales.findAll", query = "SELECT r FROM RedesSociales r"),
    @NamedQuery(name = "RedesSociales.findById", query = "SELECT r FROM RedesSociales r WHERE r.id = :id"),
    @NamedQuery(name = "RedesSociales.findByNombre", query = "SELECT r FROM RedesSociales r WHERE r.nombre = :nombre"),
    @NamedQuery(name = "RedesSociales.findByPagina", query = "SELECT r FROM RedesSociales r WHERE r.pagina = :pagina")})
public class RedesSociales implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "pagina")
    private String pagina;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "redesSociales")
    private List<AutoresRs> autoresRsList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "redesSociales")
    private List<EditorialesRs> editorialesRsList;

    public RedesSociales() {
    }

    public RedesSociales(Integer id) {
        this.id = id;
    }

    public RedesSociales(Integer id, String nombre, String pagina) {
        this.id = id;
        this.nombre = nombre;
        this.pagina = pagina;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPagina() {
        return pagina;
    }

    public void setPagina(String pagina) {
        this.pagina = pagina;
    }

    @XmlTransient
    public List<AutoresRs> getAutoresRsList() {
        return autoresRsList;
    }

    public void setAutoresRsList(List<AutoresRs> autoresRsList) {
        this.autoresRsList = autoresRsList;
    }

    @XmlTransient
    public List<EditorialesRs> getEditorialesRsList() {
        return editorialesRsList;
    }

    public void setEditorialesRsList(List<EditorialesRs> editorialesRsList) {
        this.editorialesRsList = editorialesRsList;
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
        if (!(object instanceof RedesSociales)) {
            return false;
        }
        RedesSociales other = (RedesSociales) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.RedesSociales[ id=" + id + " ]";
    }
    
}
