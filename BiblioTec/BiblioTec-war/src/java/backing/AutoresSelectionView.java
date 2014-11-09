/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backing;

import entity.Autores;
import java.io.Serializable;
import java.util.List;
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
@ManagedBean(name = "dtAutoresSelectionView")
@ViewScoped
public class AutoresSelectionView implements Serializable {

    private List<Autores> autores;
    private Autores autor;
    private Autores autorTableSelected;

    @ManagedProperty("#{autoresService}")
    private AutoresService service;

    @PostConstruct
    public void init() {
        this.setAutor(new Autores());
        this.setAutorTableSelected(new Autores());
        autores = service.getAutoresService().findAll();
    }

    public Autores getAutorTableSelected() {
        return autorTableSelected;
    }

    public void setAutorTableSelected(Autores autorTableSelected) {
        this.autorTableSelected = autorTableSelected;
    }

    public void resetAutorTableSelectedClick() {
        this.autorTableSelected = new Autores();
    }

    public Autores getAutor() {
        return autor;
    }

    public void setAutor(Autores autor) {
        this.autor = autor;
    }

    public List<Autores> getAutores() {
        return autores;
    }

    public void setAutores(List<Autores> autores) {
        this.autores = autores;
    }

    public AutoresService getService() {
        return service;
    }

    public void setService(AutoresService service) {
        this.service = service;
    }

    /**
     *
     * @param event
     */
    public void onRowSelect(SelectEvent event) {
        this.autorTableSelected = (Autores) event.getObject();
        System.out.println("Autor selecionado desde tabla: " + this.autorTableSelected.getAlias());
        FacesMessage msg = new FacesMessage("Car Selected", ((Autores) event.getObject()).getAlias());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void eliminar() {
        if (this.autorTableSelected != null) {
            System.out.println("Se eliminara: " + autorTableSelected.getAlias());
            service.getAutoresService().remove(autorTableSelected);
            autores = service.getAutoresService().findAll();
            System.out.println("Se elimino");
            addMessage("Se elimino a un autor", "Se elimino a un autor");
        } else {
            System.out.println("No se ha selecionado el autor previamente.");
        }
        // return "index?faces-redirect=true";
    }

    public void nuevoAutorClick() {
        if (this.getAutor() != null) {
            this.getService().getAutoresService().create(this.getAutor());
            this.setAutores(this.getService().getAutoresService().findAll());
            addMessage("Nuevo Autor", "Se dio de alta a un nuevo autor correctamente.");
            System.out.println("Se creo un nuevo autor: " + getAutor().getAlias());
        } else {
            System.out.println("El autor no se pudo crear.");
        }
        //return "index?faces-redirect=true";
    }

    public String editarAutorClick() {
        if (this.autorTableSelected != null) {
            this.service.getAutoresService().edit(this.autorTableSelected);
            autores = service.getAutoresService().findAll();
        }
        return "index?faces-redirect=true";
    }

}
