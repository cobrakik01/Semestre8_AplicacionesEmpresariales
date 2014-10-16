/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Autores;
import facade.AutoresFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author cobrakik
 */
@Stateless
public class AutoresService implements AutoresServiceLocal {
    @EJB
    private AutoresFacadeLocal autoresFacade;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public void create(Autores autores) {
        this.autoresFacade.create(autores);
    }

    @Override
    public void edit(Autores autores) {
        this.autoresFacade.edit(autores);
    }

    @Override
    public void remove(Autores autores) {
        this.autoresFacade.remove(autores);
    }

    @Override
    public Autores find(Integer id) {
        return this.autoresFacade.find(id);
    }

    @Override
    public List<Autores> findAll() {
        return this.autoresFacade.findAll();
    }

    @Override
    public List<Autores> findRange(int[] range) {
        return this.autoresFacade.findRange(range);
    }

    @Override
    public int count() {
        return this.autoresFacade.count();
    }

    @Override
    public List<Autores> findByApp(String app) {
        return this.autoresFacade.findByApp(app);
    }

    @Override
    public List<Autores> findByApm(String apm) {
        return this.autoresFacade.findByApm(apm);
    }

    @Override
    public List<Autores> findByAlias(String alias) {
        return this.autoresFacade.findByAlias(alias);
    }

    @Override
    public List<Autores> findByPages(Integer pages) {
        return this.autoresFacade.findByPages(pages);
    }

    @Override
    public Autores findByEmail(String email) throws Exception {
        return this.autoresFacade.findByEmail(email);
    }
    
    
    
}
