/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backing;

import entity.Editoriales;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import service.EditorialesServiceLocal;

/**
 *
 * @author cobrakik
 */
@ManagedBean(name = "mbEditorial")
@ApplicationScoped
public class EditorialManagedBean {

    @EJB
    private EditorialesServiceLocal service;

    private Editoriales editorial = new Editoriales();

    /**
     * Creates a new instance of EditorialManagedBean
     */
    public EditorialManagedBean() {
    }

    public EditorialesServiceLocal getService() {
        return service;
    }

    public void setService(EditorialesServiceLocal service) {
        this.service = service;
    }

    public Editoriales getEditorial() {
        return editorial;
    }

    public void setEditorial(Editoriales editorial) {
        this.editorial = editorial;
    }

}
