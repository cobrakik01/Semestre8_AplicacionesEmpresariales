/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.TiposTemas;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author cobrakik
 */
@Stateless
public class TiposTemasFacade extends AbstractFacade<TiposTemas> implements TiposTemasFacadeLocal {
    @PersistenceContext(unitName = "BiblioTec-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TiposTemasFacade() {
        super(TiposTemas.class);
    }
    
}
