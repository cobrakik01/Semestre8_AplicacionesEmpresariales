/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.Editoriales;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author cobrakik
 */
@Stateless
public class EditorialesFacade extends AbstractFacade<Editoriales> implements EditorialesFacadeLocal {
    @PersistenceContext(unitName = "BiblioTec-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EditorialesFacade() {
        super(Editoriales.class);
    }

    @Override
    public List<Editoriales> findByNombre(String nombre) {
        return this.getEntityManager().createNamedQuery("Editoriales.findByNombre").setParameter("nombre", nombre).getResultList();
    }

    @Override
    public List<Editoriales> findByTelefono(String telefono) {
        return this.getEntityManager().createNamedQuery("Editoriales.findByTel").setParameter("tel", telefono).getResultList();
    }

    @Override
    public List<Editoriales> findByDireccion(String direccion) {
        return this.getEntityManager().createNamedQuery("Editoriales.findByCalleNumero").setParameter("calleNumero", direccion).getResultList();
    }

    @Override
    public List<Editoriales> findByColonia(String colonia) {
        return this.getEntityManager().createNamedQuery("Editoriales.findByColonia").setParameter("colonia", colonia).getResultList();
    }

    @Override
    public List<Editoriales> findByCiudad(String ciudad) {
        return this.getEntityManager().createNamedQuery("Editoriales.findByCiudad").setParameter("ciudad", ciudad).getResultList();
    }
    
}
