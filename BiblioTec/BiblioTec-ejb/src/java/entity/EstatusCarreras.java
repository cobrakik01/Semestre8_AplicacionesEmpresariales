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
import javax.persistence.FetchType;
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
@Table(name = "estatus_carreras", catalog = "bibliotec", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstatusCarreras.findAll", query = "SELECT e FROM EstatusCarreras e"),
    @NamedQuery(name = "EstatusCarreras.findById", query = "SELECT e FROM EstatusCarreras e WHERE e.id = :id"),
    @NamedQuery(name = "EstatusCarreras.findByEstatus", query = "SELECT e FROM EstatusCarreras e WHERE e.estatus = :estatus"),
    @NamedQuery(name = "EstatusCarreras.findByClaveEstatus", query = "SELECT e FROM EstatusCarreras e WHERE e.claveEstatus = :claveEstatus")})
public class EstatusCarreras implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "estatus")
    private String estatus;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "clave_estatus")
    private String claveEstatus;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estatusCarrerasId", fetch = FetchType.LAZY)
    private List<Carreras> carrerasList;

    public EstatusCarreras() {
    }

    public EstatusCarreras(Integer id) {
        this.id = id;
    }

    public EstatusCarreras(Integer id, String estatus, String claveEstatus) {
        this.id = id;
        this.estatus = estatus;
        this.claveEstatus = claveEstatus;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public String getClaveEstatus() {
        return claveEstatus;
    }

    public void setClaveEstatus(String claveEstatus) {
        this.claveEstatus = claveEstatus;
    }

    @XmlTransient
    public List<Carreras> getCarrerasList() {
        return carrerasList;
    }

    public void setCarrerasList(List<Carreras> carrerasList) {
        this.carrerasList = carrerasList;
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
        if (!(object instanceof EstatusCarreras)) {
            return false;
        }
        EstatusCarreras other = (EstatusCarreras) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.EstatusCarreras[ id=" + id + " ]";
    }
    
}
