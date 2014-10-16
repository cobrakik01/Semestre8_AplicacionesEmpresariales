/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.Accesos;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author cobrakik
 */
@Stateless
public class AccesosFacade extends AbstractFacade<Accesos> implements AccesosFacadeLocal {

    @PersistenceContext(unitName = "BiblioTec-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AccesosFacade() {
        super(Accesos.class);
    }

    @Override
    public Accesos findByName(String nombre) {
        Accesos acceso = null;
        List list = em.createNamedQuery("Accesos.findByUsuario").setParameter("usuario", nombre).getResultList();
        if (list.size() > 0) {
            acceso = (Accesos) list.get(0);
        }
        return acceso;
    }

}
