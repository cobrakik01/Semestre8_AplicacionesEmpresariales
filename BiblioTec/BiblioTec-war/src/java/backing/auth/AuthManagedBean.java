/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backing.auth;

import entity.Accesos;
import entity.Usuarios;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import service.AccesosServiceLocal;

/**
 *
 * @author cobrakik
 */
@ManagedBean(name = "authManagedBean")
@SessionScoped
public class AuthManagedBean {

    @EJB
    private AccesosServiceLocal accesosService;
    private Accesos usuario;
    private boolean errores = false;

    /**
     * Creates a new instance of AuthManagedBean
     */
    public AuthManagedBean() {
        usuario = new Accesos();
    }

    public boolean isErrores() {
        return errores;
    }

    public void setErrores(boolean errores) {
        this.errores = errores;
    }

    public Accesos getUsuario() {
        return usuario;
    }

    public void setUsuario(Accesos usuario) {
        this.usuario = usuario;
    }

    public String login() {
        String msg = "No se pudo iniciar sesion.";
        FacesMessage fm = new FacesMessage();
        fm.setDetail(msg);
        fm.setSummary(msg);
        FacesContext fc = FacesContext.getCurrentInstance();
        String mg = null; // Esto seria para un mensaje global

        Accesos acceso = accesosService.findByName(this.usuario.getUsuario());
        if (acceso != null && acceso.getPassword().equals(this.getUsuario().getPassword())) {
            msg = "Sesion correcta.";
            fm.setSeverity(FacesMessage.SEVERITY_INFO);
            fm.setDetail(msg);
            fm.setSummary(msg);
            fc.addMessage(mg, fm);
            this.setErrores(false);
            this.setUsuario(acceso);
            return "dashboard/index?faces-redirect=true";
        }
        
        this.setUsuario(new Accesos());
        fc.addMessage(mg, fm);
        this.setErrores(true);
        return "login";
    }

    public String logout() {
        this.setUsuario(new Accesos());
        return "/login";
    }

    public boolean check() {
        return getUsuario().getId() > 0 && accesosService.find(this.getUsuario().getId()) != null;
    }

}
