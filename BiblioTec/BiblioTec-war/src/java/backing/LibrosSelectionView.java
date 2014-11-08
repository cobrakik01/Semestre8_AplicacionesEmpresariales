/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backing;

import entity.Autores;
import entity.Editoriales;
import entity.Libros;
import facade.exception.AutorNotFoundException;
import facade.exception.EditorialNotFoundException;
import facade.exception.LibroRepeatException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    private LibrosService service;

    @ManagedProperty("#{mbEditorial}")
    private EditorialManagedBean mbEditorial;

    private List<Libros> libros = new LinkedList<>();
    private Libros libroSelected = new Libros();
    private Libros libroNuevo = new Libros();
    private Editoriales editorial = new Editoriales();
    private Autores autor;

    private Integer autorId;

    @PostConstruct
    public void init() {
        this.setLibros(this.getService().getLibrosService().findAll());
        autor = new Autores();
    }

    public EditorialManagedBean getMbEditorial() {
        return mbEditorial;
    }

    public void setMbEditorial(EditorialManagedBean mbEditorial) {
        this.mbEditorial = mbEditorial;
    }

    public LibrosService getService() {
        return service;
    }

    public Editoriales getEditorial() {
        return editorial;
    }

    public void setEditorial(Editoriales editorial) {
        this.editorial = editorial;
    }

    public Autores getAutor() {
        return autor;
    }

    public void setAutor(Autores autor) {
        this.autor = autor;
    }

    public void setService(LibrosService service) {
        this.service = service;
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

    public void onChangeEditorial() {
        if (mbEditorial.getEditorial() != null) {
            System.out.println("Editorial seleccionada: " + mbEditorial.getEditorial().getNombre());
        } else {
            System.out.println("No se ha seleccionado ninguna editorial.");
        }
    }

    public void nuevoClick() {
        if (mbEditorial.getEditorial() != null) {
            System.out.println("Editorial seleccionada: " + mbEditorial.getEditorial().getNombre());
        }
        /*
         try {
         this.librosService.create(this.libroNuevo);
         addMessage("Nuevo Libro", "Se dio de alta un nuevo libro.");
         } catch (LibroRepeatException ex) {
         Logger.getLogger(LibrosSelectionView.class.getName()).log(Level.SEVERE, null, ex);
         addMessage("Nuevo Libro", ex.getLocalizedMessage());
         } catch (AutorNotFoundException ex) {
         Logger.getLogger(LibrosSelectionView.class.getName()).log(Level.SEVERE, null, ex);
         addMessage("Nuevo Libro", ex.getLocalizedMessage());
         } catch (EditorialNotFoundException ex) {
         Logger.getLogger(LibrosSelectionView.class.getName()).log(Level.SEVERE, null, ex);
         addMessage("Nuevo Libro", ex.getLocalizedMessage());
         }
         */
    }

    private void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

}
