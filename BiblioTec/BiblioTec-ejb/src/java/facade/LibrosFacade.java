/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.Autores;
import entity.Editoriales;
import entity.Libros;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author cobrakik
 */
@Stateless
public class LibrosFacade extends AbstractFacade<Libros> implements LibrosFacadeLocal {

    @PersistenceContext(unitName = "BiblioTec-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LibrosFacade() {
        super(Libros.class);
    }

    @Override
    public List<Libros> findByAutores(Autores autor) {
        return this.getEntityManager().createNamedQuery("Libros.findByAutorId").setParameter("autorId", autor.getId()).getResultList();
    }

    @Override
    public List<Libros> findByEditorial(Editoriales editorial) {
        return this.getEntityManager().createNamedQuery("Libros.findByEditorialId").setParameter("editorialId", editorial.getId()).getResultList();
    }

    @Override
    public List<Libros> findByNoPaginas(Integer paginas) {
        return this.getEntityManager().createNamedQuery("Libros.findByNoPaginas").setParameter("noPaginas", paginas).getResultList();
    }

    @Override
    public List<Libros> findByTitulo(String titulo) {
        return this.getEntityManager().createNamedQuery("Libros.findByTitulo").setParameter("titulo", titulo).getResultList();
    }

    @Override
    public List<Libros> findByEdicion(String edicion) {
        return this.getEntityManager().createNamedQuery("Libros.findByEdicion").setParameter("edicion", edicion).getResultList();
    }

    @Override
    public Libros findByIsbn(String isbn) {
        Libros libro = null;
        List list = this.getEntityManager().createNamedQuery("Libros.findByIsbn").setParameter("isbn", isbn).getResultList();
        if (list.size() > 0) {
            libro = (Libros) list.get(0);
        }
        return libro;
    }

}
