/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backing;

import entity.Autores;
import entity.Editoriales;
import entity.Libros;
import entity.LibrosPK;
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
@ManagedBean(name = "mbLibros")
@ViewScoped
public class LibrosManagedBean {

    @ManagedProperty("#{mbLibrosService}")
    private LibrosManagedBeanService mbLibrosService;

    private List<Libros> libros;
    private Libros currentLibro;
    private Libros libroSeleccionado;
    private Autores autorSeleccionado;
    private Editoriales editorialSeleccionado;

    @PostConstruct
    public void init() {
        this.reset();
    }

    public LibrosManagedBeanService getMbLibrosService() {
        return mbLibrosService;
    }

    public void setMbLibrosService(LibrosManagedBeanService mbLibrosService) {
        this.mbLibrosService = mbLibrosService;
    }

    public List<Libros> getLibros() {
        return libros;
    }

    public void setLibros(List<Libros> libros) {
        this.libros = libros;
    }

    public Libros getCurrentLibro() {
        return currentLibro;
    }

    public void setCurrentLibro(Libros currentLibro) {
        this.currentLibro = currentLibro;
    }

    public Libros getLibroSeleccionado() {
        return libroSeleccionado;
    }

    public void setLibroSeleccionado(Libros libroSeleccionado) {
        this.libroSeleccionado = libroSeleccionado;
    }

    public Autores getAutorSeleccionado() {
        return autorSeleccionado;
    }

    public void setAutorSeleccionado(Autores autorSeleccionado) {
        this.autorSeleccionado = autorSeleccionado;
    }

    public Editoriales getEditorialSeleccionado() {
        return editorialSeleccionado;
    }

    public void setEditorialSeleccionado(Editoriales editorialSeleccionado) {
        this.editorialSeleccionado = editorialSeleccionado;
    }

    public void onRowSelect(SelectEvent event) {

    }
    
    public void nuevoLibroClick() {
        
    }
    
    public void editarLibroClick() {
        
    }
    
    public void limpiarLibroClick() {
        this.reset();
    }

    private void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    private void reset() {
        libros = this.mbLibrosService.getLibrosService().findAll();
        currentLibro = new Libros(new LibrosPK());
        libroSeleccionado = new Libros(new LibrosPK());
        autorSeleccionado = new Autores();
        editorialSeleccionado = new Editoriales();
    }

}
