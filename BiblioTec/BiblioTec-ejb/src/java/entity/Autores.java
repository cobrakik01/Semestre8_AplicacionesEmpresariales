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
@Table(name = "autores", catalog = "bibliotec", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Autores.findAll", query = "SELECT a FROM Autores a"),
    @NamedQuery(name = "Autores.findById", query = "SELECT a FROM Autores a WHERE a.id = :id"),
    @NamedQuery(name = "Autores.findByNombre", query = "SELECT a FROM Autores a WHERE a.nombre = :nombre"),
    @NamedQuery(name = "Autores.findByApellidoP", query = "SELECT a FROM Autores a WHERE a.apellidoP = :apellidoP"),
    @NamedQuery(name = "Autores.findByApellidoM", query = "SELECT a FROM Autores a WHERE a.apellidoM = :apellidoM"),
    @NamedQuery(name = "Autores.findByAlias", query = "SELECT a FROM Autores a WHERE a.alias = :alias"),
    @NamedQuery(name = "Autores.findByPagina", query = "SELECT a FROM Autores a WHERE a.pagina = :pagina"),
    @NamedQuery(name = "Autores.findByEmail", query = "SELECT a FROM Autores a WHERE a.email = :email")})
public class Autores implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 45)
    @Column(name = "apellido_p")
    private String apellidoP;
    @Size(max = 45)
    @Column(name = "apellido_m")
    private String apellidoM;
    @Size(max = 15)
    @Column(name = "alias")
    private String alias;
    @Size(max = 30)
    @Column(name = "pagina")
    private String pagina;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "email")
    private String email;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "autores", fetch = FetchType.LAZY)
    private List<AutoresRs> autoresRsList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "autores", fetch = FetchType.LAZY)
    private List<Libros> librosList;

    public Autores() {
    }

    public Autores(Integer id) {
        this.id = id;
    }

    public Autores(Integer id, String email) {
        this.id = id;
        this.email = email;
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

    public String getApellidoP() {
        return apellidoP;
    }

    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    public String getApellidoM() {
        return apellidoM;
    }

    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getPagina() {
        return pagina;
    }

    public void setPagina(String pagina) {
        this.pagina = pagina;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @XmlTransient
    public List<AutoresRs> getAutoresRsList() {
        return autoresRsList;
    }

    public void setAutoresRsList(List<AutoresRs> autoresRsList) {
        this.autoresRsList = autoresRsList;
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
        if (!(object instanceof Autores)) {
            return false;
        }
        Autores other = (Autores) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        if(this.getNombre() != null && !this.getNombre().equalsIgnoreCase("")) {
            return this.getNombre();
        } else if(this.getAlias() != null && !this.getAlias().equalsIgnoreCase("")) {
            return this.getAlias();
        } else if(this.getId() != null && this.getId() > 0) {
            return String.valueOf(this.getId());
        }
        return "";
    }
    
}
