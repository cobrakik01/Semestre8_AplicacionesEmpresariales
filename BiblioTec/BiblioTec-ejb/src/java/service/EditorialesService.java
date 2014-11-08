/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Editoriales;
import facade.EditorialesFacadeLocal;
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
    public void create(Editoriales editoriales) {
        this.editorialesFacade.create(editoriales);
    }

    @Override
    public void edit(Editoriales editoriales) {
        this.editorialesFacade.edit(editoriales);
    }

    @Override
    public void remove(Editoriales editoriales) {
        this.editorialesFacade.remove(editoriales);
    }

    @Override
    public Editoriales find(Object id) {
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
    
}
