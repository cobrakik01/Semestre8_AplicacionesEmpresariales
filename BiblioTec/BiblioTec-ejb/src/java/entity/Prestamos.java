/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author cobrakik
 */
@Entity
@Table(name = "prestamos", catalog = "bibliotec", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Prestamos.findAll", query = "SELECT p FROM Prestamos p"),
    @NamedQuery(name = "Prestamos.findById", query = "SELECT p FROM Prestamos p WHERE p.id = :id"),
    @NamedQuery(name = "Prestamos.findByObservaciones", query = "SELECT p FROM Prestamos p WHERE p.observaciones = :observaciones"),
    @NamedQuery(name = "Prestamos.findByFechaSalida", query = "SELECT p FROM Prestamos p WHERE p.fechaSalida = :fechaSalida"),
    @NamedQuery(name = "Prestamos.findByFechaEntregaProgramada", query = "SELECT p FROM Prestamos p WHERE p.fechaEntregaProgramada = :fechaEntregaProgramada"),
    @NamedQuery(name = "Prestamos.findByFechaEntregaReal", query = "SELECT p FROM Prestamos p WHERE p.fechaEntregaReal = :fechaEntregaReal")})
public class Prestamos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 100)
    @Column(name = "observaciones")
    private String observaciones;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_salida")
    @Temporal(TemporalType.DATE)
    private Date fechaSalida;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_entrega_programada")
    @Temporal(TemporalType.DATE)
    private Date fechaEntregaProgramada;
    @Column(name = "fecha_entrega_real")
    @Temporal(TemporalType.DATE)
    private Date fechaEntregaReal;
    @JoinColumn(name = "accesos_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Accesos accesosId;
    @JoinColumn(name = "estatus_prestamos_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private EstatusPrestamos estatusPrestamosId;
    @JoinColumns({
        @JoinColumn(name = "libros_id", referencedColumnName = "id"),
        @JoinColumn(name = "libros_autor_id", referencedColumnName = "autor_id"),
        @JoinColumn(name = "libros_editorial_id", referencedColumnName = "editorial_id")})
    @ManyToOne(optional = false)
    private Libros libros;
    @JoinColumn(name = "tipos_renovacion_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TiposRenovacion tiposRenovacionId;
    @JoinColumn(name = "usuarios_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Usuarios usuariosId;

    public Prestamos() {
    }

    public Prestamos(Integer id) {
        this.id = id;
    }

    public Prestamos(Integer id, Date fechaSalida, Date fechaEntregaProgramada) {
        this.id = id;
        this.fechaSalida = fechaSalida;
        this.fechaEntregaProgramada = fechaEntregaProgramada;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public Date getFechaEntregaProgramada() {
        return fechaEntregaProgramada;
    }

    public void setFechaEntregaProgramada(Date fechaEntregaProgramada) {
        this.fechaEntregaProgramada = fechaEntregaProgramada;
    }

    public Date getFechaEntregaReal() {
        return fechaEntregaReal;
    }

    public void setFechaEntregaReal(Date fechaEntregaReal) {
        this.fechaEntregaReal = fechaEntregaReal;
    }

    public Accesos getAccesosId() {
        return accesosId;
    }

    public void setAccesosId(Accesos accesosId) {
        this.accesosId = accesosId;
    }

    public EstatusPrestamos getEstatusPrestamosId() {
        return estatusPrestamosId;
    }

    public void setEstatusPrestamosId(EstatusPrestamos estatusPrestamosId) {
        this.estatusPrestamosId = estatusPrestamosId;
    }

    public Libros getLibros() {
        return libros;
    }

    public void setLibros(Libros libros) {
        this.libros = libros;
    }

    public TiposRenovacion getTiposRenovacionId() {
        return tiposRenovacionId;
    }

    public void setTiposRenovacionId(TiposRenovacion tiposRenovacionId) {
        this.tiposRenovacionId = tiposRenovacionId;
    }

    public Usuarios getUsuariosId() {
        return usuariosId;
    }

    public void setUsuariosId(Usuarios usuariosId) {
        this.usuariosId = usuariosId;
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
        if (!(object instanceof Prestamos)) {
            return false;
        }
        Prestamos other = (Prestamos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Prestamos[ id=" + id + " ]";
    }
    
}
