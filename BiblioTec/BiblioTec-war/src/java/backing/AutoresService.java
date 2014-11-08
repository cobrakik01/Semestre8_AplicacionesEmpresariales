/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backing;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import service.AutoresServiceLocal;

/**
 *
 * @author cobrakik
 */
@ManagedBean
@ApplicationScoped
public class AutoresService {

    @EJB
    private AutoresServiceLocal autoresService;

    /**
     * Creates a new instance of AutoresService
     */
    public AutoresService() {
    }

    public AutoresServiceLocal getAutoresService() {
        return autoresService;
    }

    public void setAutoresService(AutoresServiceLocal autoresService) {
        this.autoresService = autoresService;
    }

}
