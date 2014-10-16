/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.Autores;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author cobrakik
 */
@Stateless
public class AutoresFacade extends AbstractFacade<Autores> implements AutoresFacadeLocal {

    @PersistenceContext(unitName = "BiblioTec-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AutoresFacade() {
        super(Autores.class);
    }

    @Override
    public List<Autores> findByApp(String app) {
        return this.getEntityManager().createNamedQuery("Autores.findByApellidoP").setParameter("apellidoP", app).getResultList();
    }

    @Override
    public List<Autores> findByApm(String apm) {
        return this.getEntityManager().createNamedQuery("Autores.findByApellidoM").setParameter("apellidoM", apm).getResultList();
    }

    @Override
    public List<Autores> findByAlias(String alias) {
        return this.getEntityManager().createNamedQuery("Autores.findByAlias").setParameter("alias", alias).getResultList();
    }

    @Override
    public List<Autores> findByPages(Integer pages) {
        return this.getEntityManager().createNamedQuery("Autores.findByPagina").setParameter("pagina", pages).getResultList();
    }

    @Override
    public Autores findByEmail(String email) throws Exception {
        Autores a = null;
        List lista = this.getEntityManager().createNamedQuery("Autores.findByEmail").setParameter("email", email).getResultList();
        if (lista.size() > 0) {
            a = (Autores) lista.get(0);
        } else {
            throw new Exception("No se encontro el autor.");
        }
        return a;
    }

}
