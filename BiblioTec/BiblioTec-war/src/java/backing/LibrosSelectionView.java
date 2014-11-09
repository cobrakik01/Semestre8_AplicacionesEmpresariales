/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backing;

import entity.Autores;
import entity.Editoriales;
import entity.Libros;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import service.LibrosServiceLocal;

/**
 *
 * @author cobrakik
 */
@ManagedBean(name = "mbLibros")
@ViewScoped
public class LibrosSelectionView {

    @EJB
    private LibrosServiceLocal librosService;

    @ManagedProperty("#{mbLibrosService}")
    private LibrosService mgLibrosService;

    @ManagedProperty("#{mbEditorialesService}")
    private EditorialesManagedBeanService mbEditorialesService;

    private List<Libros> libros;
    private Libros libroSelected;
    private Libros libroNuevo;
    private Autores autorSeleccionado;
    private Editoriales editorialSeleccionado;

    private List<Editoriales> editoriales;

    private Integer autorId;

    @PostConstruct
    public void init() {
        this.libros = this.mgLibrosService.getLibrosService().findAll();
        this.editoriales = this.mbEditorialesService.getEditorialesService().findAll();
    }

    public List<Editoriales> getEditoriales() {
        return editoriales;
    }

    public void setEditoriales(List<Editoriales> editoriales) {
        this.editoriales = editoriales;
    }

    public EditorialesManagedBeanService getMbEditorialesService() {
        return mbEditorialesService;
    }

    public void setMbEditorialesService(EditorialesManagedBeanService mbEditorialesService) {
        this.mbEditorialesService = mbEditorialesService;
    }

    public LibrosService getMgLibrosService() {
        return mgLibrosService;
    }

    public void setMgLibrosService(LibrosService mgLibrosService) {
        this.mgLibrosService = mgLibrosService;
    }

    public Editoriales getEditorialSeleccionado() {
        return editorialSeleccionado;
    }

    public void setEditorialSeleccionado(Editoriales editorialSeleccionado) {
        this.editorialSeleccionado = editorialSeleccionado;
    }

    public Autores getAutorSeleccionado() {
        return autorSeleccionado;
    }

    public void setAutorSeleccionado(Autores autorSeleccionado) {
        this.autorSeleccionado = autorSeleccionado;
    }

    public Integer getAutorId() {
        return autorId;
    }

    public void setAutorId(Integer autorId) {
        this.autorId = autorId;
    }

    public Libros getLibroNuevo() {
        return libroNuevo;
    }

    public void setLibroNuevo(Libros libroNuevo) {
        this.libroNuevo = libroNuevo;
    }

    public List<Libros> getLibros() {
        return libros;
    }

    public void setLibros(List<Libros> libros) {
        this.libros = libros;
    }

    public Libros getLibroSelected() {
        return libroSelected;
    }

    public void setLibroSelected(Libros libroSelected) {
        this.libroSelected = libroSelected;
    }

    public void eliminarClick() {

    }

    private void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

}
