/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backing.util;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import backing.auth.AuthFilterManagedBean;
import backing.auth.AuthManagedBean;
import javax.annotation.PreDestroy;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author cobrakik
 */
@ManagedBean(name = "mbNav")
@SessionScoped
public class NavegationManagedBean extends AuthFilterManagedBean {

    private String context;
    private String currentPage;

    /**
     * Creates a new instance of NavegationManagedBean
     */
    public NavegationManagedBean() {
        context = FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath();
    }

    @PreDestroy
    public void destroy() {

    }

    public AuthManagedBean getAuth() {
        return this.getAuthManagedBean();
    }

    public void setAuth(AuthManagedBean auth) {
        this.setAuthManagedBean(auth);
    }

    public String getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(String currentPage) {
        this.currentPage = currentPage;
    }

    public String active(String page) {
        Object request = FacesContext.getCurrentInstance().getExternalContext().getRequest();
        if (request instanceof HttpServletRequest) {
            String uri = ((HttpServletRequest) request).getRequestURI();
            if (uri.endsWith(page + ".xhtml") || uri.endsWith("/")) {
                return "active";
            }
        }
        return "";
    }

    public String home() {
        this.setCurrentPage("dashboard");
        return context + "/faces/dashboard/index.xhtml";
    }

    public String usuarios() {
        this.setCurrentPage("usuarios");
        return context + "/faces/dashboard/usuarios/index.xhtml";
    }

    public String libros() {
        this.setCurrentPage("libros");
        return context + "/faces/dashboard/libros/index.xhtml";
    }

    public String autores() {
        this.setCurrentPage("autores");
        return context + "/faces/dashboard/autores/index.xhtml";
    }

    public String editoriales() {
        this.setCurrentPage("editoriales");
        return context + "/faces/dashboard/editoriales/index.xhtml";
    }

    public String perfil() {
        this.setCurrentPage("perfil");
        return context + "/faces/dashboard/perfil/index.xhtml";
    }

    public String logout() {
        return context + "/faces/login.xhtml";
    }

}
