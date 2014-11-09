/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backing;

import entity.Editoriales;
import facade.exception.EditorialNotFoundException;
import facade.exception.EditorialRepeatException;
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
@ManagedBean(name = "mbEditorial")
@ViewScoped
public class EditorialManagedBean {

    @ManagedProperty("#{mbEditorialesService}")
    private EditorialesService mbEditorialesService;

    private List<Editoriales> editoriales;

    private Editoriales currentEditorial = new Editoriales();
    private Editoriales editorialSeleccionado = new Editoriales();

    @PostConstruct
    public void init() {
        editoriales = this.mbEditorialesService.getEditorialesService().findAll();
    }

    public Editoriales getCurrentEditorial() {
        return currentEditorial;
    }

    public void setCurrentEditorial(Editoriales currentEditorial) {
        this.currentEditorial = currentEditorial;
    }

    public Editoriales getEditorialSeleccionado() {
        return editorialSeleccionado;
    }

    public void setEditorialSeleccionado(Editoriales editorialSeleccionado) {
        this.editorialSeleccionado = editorialSeleccionado;
    }

    public EditorialesService getMbEditorialesService() {
        return mbEditorialesService;
    }

    public void setMbEditorialesService(EditorialesService mbEditorialesService) {
        this.mbEditorialesService = mbEditorialesService;
    }

    public List<Editoriales> getEditoriales() {
        return editoriales;
    }

    public void setEditoriales(List<Editoriales> editoriales) {
        this.editoriales = editoriales;
    }

    public void nuevaEditorialClick() {
        try {
            this.mbEditorialesService.getEditorialesService().create(currentEditorial);
            addMessage("Nueva Editorial", "Se dio de alta una nueva editorial.");
        } catch (EditorialRepeatException ex) {
            addMessage("Error", ex.getMessage());
            Logger.getLogger(EditorialManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        currentEditorial = new Editoriales();
        editoriales = this.mbEditorialesService.getEditorialesService().findAll();
    }

    public void editarEditorialClick() {
        if (currentEditorial != null) {
            try {
                this.mbEditorialesService.getEditorialesService().edit(currentEditorial);
                addMessage("Editar Editorial", "La editorial se actualizo correctamente.");
            } catch (EditorialRepeatException | EditorialNotFoundException ex) {
                addMessage("Error", ex.getMessage());
                Logger.getLogger(EditorialManagedBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        editorialSeleccionado = new Editoriales();
        currentEditorial = new Editoriales();
        editoriales = this.mbEditorialesService.getEditorialesService().findAll();
    }

    public void limpiarEditorialClick() {
        editorialSeleccionado = new Editoriales();
        currentEditorial = new Editoriales();
    }

    public void onRowSelect(SelectEvent event) {
        editorialSeleccionado = (Editoriales) event.getObject();
        try {
            currentEditorial = this.mbEditorialesService.getEditorialesService().find(editorialSeleccionado.getId());
        } catch (EditorialNotFoundException ex) {
            Logger.getLogger(EditorialManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

}
