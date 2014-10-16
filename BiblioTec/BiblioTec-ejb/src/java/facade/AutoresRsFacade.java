/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.AutoresRs;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author cobrakik
 */
@Stateless
public class AutoresRsFacade extends AbstractFacade<AutoresRs> implements AutoresRsFacadeLocal {
    @PersistenceContext(unitName = "BiblioTec-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AutoresRsFacade() {
        super(AutoresRs.class);
    }
    
}
