/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Autores;
import facade.AutoresFacadeLocal;
import facade.exception.AutorNotFoundException;
import facade.exception.AutorRepeatException;
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

    @Override
    public void create(Autores autores) throws AutorRepeatException {
        if (!this.exist(autores)) {
            this.autoresFacade.create(autores);
        } else {
            throw new AutorRepeatException("Ya existe el autor.");
        }
    }

    @Override
    public void edit(Autores autores) throws AutorRepeatException, AutorNotFoundException {
        Autores oldAutor = this.find(autores.getId());
        Autores newAutor = autores;
        if (oldAutor == null) {
            throw new AutorNotFoundException("Ya existe el autor.");
        } else if (!oldAutor.igual(newAutor)) {
            this.autoresFacade.edit(newAutor);
        } else if (this.exist(newAutor)) {
            throw new AutorRepeatException("Ya existe el autor.");
        }
    }

    @Override
    public void remove(Autores autores) {
        this.autoresFacade.remove(autores);
    }

    @Override
    public Autores find(Integer id) throws AutorNotFoundException {
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
    public List<Autores> findByApp(String app) throws AutorNotFoundException {
        return this.autoresFacade.findByApp(app);
    }

    @Override
    public List<Autores> findByApm(String apm) throws AutorNotFoundException {
        return this.autoresFacade.findByApm(apm);
    }

    @Override
    public List<Autores> findByAlias(String alias) throws AutorNotFoundException {
        return this.autoresFacade.findByAlias(alias);
    }

    @Override
    public List<Autores> findByPages(Integer pages) throws AutorNotFoundException {
        return this.autoresFacade.findByPages(pages);
    }

    @Override
    public Autores findByEmail(String email) throws AutorNotFoundException {
        return this.autoresFacade.findByEmail(email);
    }

    @Override
    public boolean exist(Autores autor) {
        return this.autoresFacade.findByAutor(autor).size() > 0;
    }

}
