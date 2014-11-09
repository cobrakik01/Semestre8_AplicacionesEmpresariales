/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backing;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import service.EditorialesServiceLocal;

/**
 *
 * @author cobrakik
 */
@ManagedBean(name = "mbEditorialesService")
@ApplicationScoped
public class EditorialesService {

    @EJB
    private EditorialesServiceLocal editorialesService;

    public EditorialesServiceLocal getEditorialesService() {
        return editorialesService;
    }

    public void setEditorialesService(EditorialesServiceLocal editorialesService) {
        this.editorialesService = editorialesService;
    }

}
