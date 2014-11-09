/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backing;

import entity.Autores;
import facade.exception.AutorNotFoundException;
import facade.exception.AutorRepeatException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author cobrakik
 */
@ManagedBean(name = "mbAutores")
@ViewScoped
public class AutoresManagedBean {

    @ManagedProperty("#{mbAutoresService}")
    private AutoresManagedBeanService mbAutoresService;
    private List<Autores> autores;
    private Autores currentAutor = new Autores();
    private Autores autorSeleccionado = new Autores();

    @PostConstruct
    public void init() {
        autores = mbAutoresService.getAutoresService().findAll();
    }

    public AutoresManagedBeanService getMbAutoresService() {
        return mbAutoresService;
    }

    public void setMbAutoresService(AutoresManagedBeanService mbAutoresService) {
        this.mbAutoresService = mbAutoresService;
    }

    public List<Autores> getAutores() {
        return autores;
    }

    public void setAutores(List<Autores> autores) {
        this.autores = autores;
    }

    public Autores getCurrentAutor() {
        return currentAutor;
    }

    public void setCurrentAutor(Autores currentAutor) {
        this.currentAutor = currentAutor;
    }

    public Autores getAutorSeleccionado() {
        return autorSeleccionado;
    }

    public void setAutorSeleccionado(Autores autorSeleccionado) {
        this.autorSeleccionado = autorSeleccionado;
    }

    public void onRowSelect(SelectEvent event) {
        autorSeleccionado = (Autores) event.getObject();
        try {
            currentAutor = this.mbAutoresService.getAutoresService().find(autorSeleccionado.getId());
        } catch (AutorNotFoundException ex) {
            addMessage("Error", ex.getMessage(), FacesMessage.SEVERITY_WARN);
            Logger.getLogger(AutoresManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void nuevoAutorClick() {
        try {
            if (currentAutor != null) {
                this.mbAutoresService.getAutoresService().create(currentAutor);
                addMessage("Nuevo autor", "Se dio de alta a un nuevo autor correctamente.", FacesMessage.SEVERITY_INFO);
            }
            System.out.println(currentAutor);
        } catch (AutorRepeatException ex) {
            addMessage("Advertencia", ex.getMessage(), FacesMessage.SEVERITY_WARN);
            Logger.getLogger(AutoresManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.reset();
    }

    public void editarAutorClick() {
        if(currentAutor != null) {
            try {
                this.mbAutoresService.getAutoresService().edit(currentAutor);
                addMessage("Editar Autor", "El autor se actualizo correctamente.", FacesMessage.SEVERITY_INFO);
            } catch (AutorRepeatException | AutorNotFoundException ex) {
                addMessage("Advertencia", ex.getMessage(), FacesMessage.SEVERITY_WARN);
                Logger.getLogger(AutoresManagedBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        this.reset();
    }

    public void limpiarAutorClick() {
        this.reset();
    }

    private void addMessage(String summary, String detail, FacesMessage.Severity severity) {
        FacesMessage message = new FacesMessage(severity, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    private void reset() {
        this.currentAutor = new Autores();
        this.autorSeleccionado = new Autores();
        this.autores = this.mbAutoresService.getAutoresService().findAll();
    }

}
