/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Editoriales;
import facade.EditorialesFacadeLocal;
import facade.exception.EditorialNotFoundException;
import facade.exception.EditorialRepeatException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author cobrakik
 */
@Stateless
public class EditorialesService implements EditorialesServiceLocal {

    @EJB
    private EditorialesFacadeLocal editorialesFacade;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Override
    public void create(Editoriales editoriales) throws EditorialRepeatException {
        if (this.editorialesFacade.findByNombre(editoriales.getNombre()).size() > 0) {
            throw new EditorialRepeatException("Ya existe una editorial con el mismo nombre.");
        }
        this.editorialesFacade.create(editoriales);
    }

    @Override
    public void edit(Editoriales editoriales) throws EditorialRepeatException, EditorialNotFoundException {
        Editoriales oldData = this.editorialesFacade.find(editoriales.getId());
        Editoriales newData = editoriales;
        
        if(oldData == null) {
            throw new EditorialNotFoundException();
        } if (oldData.getNombre().equalsIgnoreCase(newData.getNombre()) || this.editorialesFacade.findByNombre(newData.getNombre()).size() <= 0 ) {
            this.editorialesFacade.edit(editoriales);
        } else {
            throw new EditorialRepeatException("Ya existe una editorial con el mismo nombre.");
        }
    }

    @Override
    public void remove(Editoriales editoriales) {
        this.editorialesFacade.remove(editoriales);
    }

    @Override
    public Editoriales find(Object id) throws EditorialNotFoundException {
        if (this.editorialesFacade.find(id) == null) {
            throw new EditorialNotFoundException();
        }
        return this.editorialesFacade.find(id);
    }

    @Override
    public List<Editoriales> findAll() {
        return this.editorialesFacade.findAll();
    }

    @Override
    public List<Editoriales> findRange(int[] range) {
        return this.editorialesFacade.findRange(range);
    }

    @Override
    public int count() {
        return this.editorialesFacade.count();
    }

    @Override
    public Editoriales findByNombre(String nombre) throws EditorialNotFoundException {
        Editoriales e = null;
        List<Editoriales> result = this.editorialesFacade.findByNombre(nombre);
        if (result.size() <= 0) {
            throw new EditorialNotFoundException();
        }
        return e;
    }

    @Override
    public List<Editoriales> findByTelefono(String telefono) throws EditorialNotFoundException {
        List<Editoriales> result = this.editorialesFacade.findByTelefono(telefono);
        if (result.size() <= 0) {
            throw new EditorialNotFoundException();
        }
        return result;
    }

    @Override
    public List<Editoriales> findByDireccion(String direccion) throws EditorialNotFoundException {
        List<Editoriales> result = this.editorialesFacade.findByDireccion(direccion);
        if (result.size() <= 0) {
            throw new EditorialNotFoundException();
        }
        return result;
    }

    @Override
    public List<Editoriales> findByColonia(String colonia) throws EditorialNotFoundException {
        List<Editoriales> result = this.editorialesFacade.findByColonia(colonia);
        if (result.size() <= 0) {
            throw new EditorialNotFoundException();
        }
        return result;
    }

    @Override
    public List<Editoriales> findByCiudad(String ciudad) throws EditorialNotFoundException {
        List<Editoriales> result = this.editorialesFacade.findByCiudad(ciudad);
        if (result.size() <= 0) {
            throw new EditorialNotFoundException();
        }
        return result;
    }

}
