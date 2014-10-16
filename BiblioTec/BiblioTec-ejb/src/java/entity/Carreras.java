/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author cobrakik
 */
@Entity
@Table(name = "carreras", catalog = "bibliotec", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Carreras.findAll", query = "SELECT c FROM Carreras c"),
    @NamedQuery(name = "Carreras.findById", query = "SELECT c FROM Carreras c WHERE c.id = :id"),
    @NamedQuery(name = "Carreras.findByClave", query = "SELECT c FROM Carreras c WHERE c.clave = :clave"),
    @NamedQuery(name = "Carreras.findByNombreCarrera", query = "SELECT c FROM Carreras c WHERE c.nombreCarrera = :nombreCarrera"),
    @NamedQuery(name = "Carreras.findByAbreviaturaCarrera", query = "SELECT c FROM Carreras c WHERE c.abreviaturaCarrera = :abreviaturaCarrera"),
    @NamedQuery(name = "Carreras.findByFechaApertura", query = "SELECT c FROM Carreras c WHERE c.fechaApertura = :fechaApertura"),
    @NamedQuery(name = "Carreras.findByFechaCierre", query = "SELECT c FROM Carreras c WHERE c.fechaCierre = :fechaCierre")})
public class Carreras implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "clave")
    private String clave;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "nombre_carrera")
    private String nombreCarrera;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "abreviatura_carrera")
    private String abreviaturaCarrera;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_apertura")
    @Temporal(TemporalType.DATE)
    private Date fechaApertura;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_cierre")
    @Temporal(TemporalType.DATE)
    private Date fechaCierre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "carrerasId")
    private List<Usuarios> usuariosList;
    @JoinColumn(name = "estatus_carreras_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private EstatusCarreras estatusCarrerasId;

    public Carreras() {
    }

    public Carreras(Integer id) {
        this.id = id;
    }

    public Carreras(Integer id, String clave, String nombreCarrera, String abreviaturaCarrera, Date fechaApertura, Date fechaCierre) {
        this.id = id;
        this.clave = clave;
        this.nombreCarrera = nombreCarrera;
        this.abreviaturaCarrera = abreviaturaCarrera;
        this.fechaApertura = fechaApertura;
        this.fechaCierre = fechaCierre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getNombreCarrera() {
        return nombreCarrera;
    }

    public void setNombreCarrera(String nombreCarrera) {
        this.nombreCarrera = nombreCarrera;
    }

    public String getAbreviaturaCarrera() {
        return abreviaturaCarrera;
    }

    public void setAbreviaturaCarrera(String abreviaturaCarrera) {
        this.abreviaturaCarrera = abreviaturaCarrera;
    }

    public Date getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(Date fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    public Date getFechaCierre() {
        return fechaCierre;
    }

    public void setFechaCierre(Date fechaCierre) {
        this.fechaCierre = fechaCierre;
    }

    @XmlTransient
    public List<Usuarios> getUsuariosList() {
        return usuariosList;
    }

    public void setUsuariosList(List<Usuarios> usuariosList) {
        this.usuariosList = usuariosList;
    }

    public EstatusCarreras getEstatusCarrerasId() {
        return estatusCarrerasId;
    }

    public void setEstatusCarrerasId(EstatusCarreras estatusCarrerasId) {
        this.estatusCarrerasId = estatusCarrerasId;
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
        if (!(object instanceof Carreras)) {
            return false;
        }
        Carreras other = (Carreras) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Carreras[ id=" + id + " ]";
    }
    
}
