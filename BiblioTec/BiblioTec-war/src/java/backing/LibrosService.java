/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backing;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import service.LibrosServiceLocal;

/**
 *
 * @author cobrakik
 */
@ManagedBean(name = "mbLibrosService")
@ApplicationScoped
public class LibrosService {

    @EJB
    private LibrosServiceLocal librosService;

    public LibrosServiceLocal getLibrosService() {
        return librosService;
    }

    public void setLibrosService(LibrosServiceLocal librosService) {
        this.librosService = librosService;
    }

}
