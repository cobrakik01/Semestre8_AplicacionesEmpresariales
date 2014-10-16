/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backing;

import entity.Autores;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import backing.auth.AuthFilterManagedBean;
import service.AutoresServiceLocal;

/**
 *
 * @author cobrakik
 */
@ManagedBean
@RequestScoped
public class AutoresManagedBean extends AuthFilterManagedBean {

    @EJB
    private AutoresServiceLocal autoresService;
    private Autores autor;

    /**
     * Creates a new instance of AutoresManagedBean
     */
    public AutoresManagedBean() {
        super();
        autor = new Autores();
    }

    public Autores getAutor() {
        return autor;
    }

    public void setAutor(Autores autor) {
        this.autor = autor;
    }

    public String create() {
        this.autoresService.create(this.getAutor());
        return "index";
    }

}
