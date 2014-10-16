/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Accesos;
import facade.AccesosFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author cobrakik
 */
@Stateless
public class AccesosService implements AccesosServiceLocal {

    @EJB
    private AccesosFacadeLocal accesosFacade;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public void create(Accesos accesos) {
        accesosFacade.create(accesos);
    }

    @Override
    public void edit(Accesos accesos) {
        accesosFacade.edit(accesos);
    }

    @Override
    public void remove(Accesos accesos) {
        accesosFacade.remove(accesos);
    }

    @Override
    public Accesos find(Integer id) {
        return accesosFacade.find(id);
    }

    @Override
    public List<Accesos> findAll() {
        return accesosFacade.findAll();
    }

    @Override
    public List<Accesos> findRange(int[] range) {
        return accesosFacade.findRange(range);
    }

    @Override
    public int count() {
        return accesosFacade.count();
    }

    @Override
    public Accesos findByName(String usuario) {
        return accesosFacade.findByName(usuario);
    }
}
