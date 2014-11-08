/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backing;

import javax.faces.bean.ManagedBean;
import backing.auth.AuthFilterManagedBean;
import entity.Accesos;
import facade.AccesosFacadeLocal;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author cobrakik
 */
@ManagedBean(name = "mbUsuarios")
@ViewScoped
public class UsuariosManagedBean extends AuthFilterManagedBean {

    @EJB
    private AccesosFacadeLocal accesosFacade;
    private Accesos usuario;
    private List<Accesos> usuarios;
    private List<Accesos> usuariosFiltered;

    public List<Accesos> getUsuariosFiltered() {
        return usuariosFiltered;
    }

    public void setUsuariosFiltered(List<Accesos> usuariosFiltered) {
        this.usuariosFiltered = usuariosFiltered;
    }
    

    @PostConstruct
    public void init() {
        usuarios = accesosFacade.findAll();
    }

    /**
     * Creates a new instance of UsuariosManagedBean
     */
    public UsuariosManagedBean() {
        usuario = new Accesos();
    }

    /**
     * Get the value of usuario
     *
     * @return the value of usuario
     */
    public Accesos getUsuario() {
        return usuario;
    }

    /**
     * Set the value of usuario
     *
     * @param usuario new value of usuario
     */
    public void setUsuario(Accesos usuario) {
        this.usuario = usuario;
    }

    public List<Accesos> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Accesos> usuarios) {
        this.usuarios = usuarios;
    }

    public String nuevo() {
        Accesos us = this.accesosFacade.findByName(this.getUsuario().getUsuario());
        if (us != null) {
            FacesMessage msg = new FacesMessage("El usuario ya existe.");
            FacesContext.getCurrentInstance().addMessage("msgs", msg);
            return "index";
        }
        FacesMessage msg = new FacesMessage("El usuario se dio de alta correctamente.");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        this.accesosFacade.create(this.getUsuario());
        return "index";
    }

}
