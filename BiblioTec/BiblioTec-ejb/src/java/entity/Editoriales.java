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
@Table(name = "editoriales", catalog = "bibliotec", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Editoriales.findAll", query = "SELECT e FROM Editoriales e"),
    @NamedQuery(name = "Editoriales.findById", query = "SELECT e FROM Editoriales e WHERE e.id = :id"),
    @NamedQuery(name = "Editoriales.findByTel", query = "SELECT e FROM Editoriales e WHERE e.tel = :tel"),
    @NamedQuery(name = "Editoriales.findByCalleNumero", query = "SELECT e FROM Editoriales e WHERE e.calleNumero = :calleNumero"),
    @NamedQuery(name = "Editoriales.findByColonia", query = "SELECT e FROM Editoriales e WHERE e.colonia = :colonia"),
    @NamedQuery(name = "Editoriales.findByCiudad", query = "SELECT e FROM Editoriales e WHERE e.ciudad = :ciudad")})
public class Editoriales implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "tel")
    private String tel;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "calle_numero")
    private String calleNumero;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "colonia")
    private String colonia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "ciudad")
    private String ciudad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "editoriales")
    private List<EditorialesRs> editorialesRsList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "editoriales")
    private List<Libros> librosList;

    public Editoriales() {
    }

    public Editoriales(Integer id) {
        this.id = id;
    }

    public Editoriales(Integer id, String tel, String calleNumero, String colonia, String ciudad) {
        this.id = id;
        this.tel = tel;
        this.calleNumero = calleNumero;
        this.colonia = colonia;
        this.ciudad = ciudad;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getCalleNumero() {
        return calleNumero;
    }

    public void setCalleNumero(String calleNumero) {
        this.calleNumero = calleNumero;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    @XmlTransient
    public List<EditorialesRs> getEditorialesRsList() {
        return editorialesRsList;
    }

    public void setEditorialesRsList(List<EditorialesRs> editorialesRsList) {
        this.editorialesRsList = editorialesRsList;
    }

    @XmlTransient
    public List<Libros> getLibrosList() {
        return librosList;
    }

    public void setLibrosList(List<Libros> librosList) {
        this.librosList = librosList;
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
        if (!(object instanceof Editoriales)) {
            return false;
        }
        Editoriales other = (Editoriales) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Editoriales[ id=" + id + " ]";
    }
    
}
