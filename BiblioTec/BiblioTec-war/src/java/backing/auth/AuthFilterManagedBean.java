/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backing.auth;

import facade.AccesosFacadeLocal;
import java.io.IOException;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 *
 * @author cobrakik
 */
@ManagedBean
@RequestScoped
public class AuthFilterManagedBean {
    
    @ManagedProperty(value = "#{authManagedBean}")
    private AuthManagedBean authManagedBean;

    @PostConstruct
    public void filerAuth() {
        if (!authManagedBean.check()) {
            try {
                ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
                context.redirect(context.getRequestContextPath() + "/faces/login.xhtml");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Creates a new instance of AuthFilterManagedBean
     */
    public AuthFilterManagedBean() {
    }

    public AuthManagedBean getAuthManagedBean() {
        return authManagedBean;
    }

    public void setAuthManagedBean(AuthManagedBean authManagedBean) {
        this.authManagedBean = authManagedBean;
    }
}
