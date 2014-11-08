/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Autores;
import entity.Editoriales;
import entity.Libros;
import entity.LibrosPK;
import facade.AutoresFacadeLocal;
import facade.EditorialesFacadeLocal;
import facade.LibrosFacadeLocal;
import facade.exception.AutorNotFoundException;
import facade.exception.EditorialNotFoundException;
import facade.exception.LibroNotFoundException;
import facade.exception.LibroRepeatException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author cobrakik
 */
@Stateless
public class LibrosService implements LibrosServiceLocal {

    @EJB
    private EditorialesFacadeLocal editorialesFacade;

    @EJB
    private AutoresFacadeLocal autoresFacade;

    @EJB
    private LibrosFacadeLocal librosFacade;

    @Override
    public void create(Libros libro, Integer autorId, Integer editorialId) throws LibroRepeatException, AutorNotFoundException, EditorialNotFoundException {
        libro.setEditoriales(null);
        if (libro == null) {
            throw new NullPointerException();
        }
        if (libro.getLibrosPK() == null) {
            LibrosPK pk = new LibrosPK();
            pk.setAutorId(autorId);
            pk.setEditorialId(editorialId);
            libro.setLibrosPK(pk);
        }
        this.create(libro);
    }

    @Override
    public void create(Libros libro) throws LibroRepeatException, AutorNotFoundException, EditorialNotFoundException {
        if (libro.getLibrosPK() == null) {
            throw new NullPointerException();
        }
        if (this.autoresFacade.find(libro.getLibrosPK().getAutorId()) == null) {
            throw new AutorNotFoundException("No se ha espesificado a ningun autor.");
        }
        if (this.editorialesFacade.find(libro.getLibrosPK().getEditorialId()) == null) {
            throw new EditorialNotFoundException("No se ha espesificado a ninguna editorial.");
        }
        this.librosFacade.create(libro);
    }

    @Override
    public void edit(Libros libro) throws LibroRepeatException, LibroNotFoundException {
        Libros oldLibro = this.librosFacade.find(libro.getLibrosPK().getId());
        if (oldLibro == null) {
            throw new LibroNotFoundException();
        }
        String oldIsbn = oldLibro.getIsbn();
        String newIsbn = libro.getIsbn();

        if (!oldIsbn.equalsIgnoreCase(newIsbn)) {
            Libros rLibro = this.librosFacade.findByIsbn(newIsbn);
            if (rLibro != null) { // Entonces ya existe un isbn igual
                throw new LibroRepeatException("Ya existe un libro con el mismo ISBN");
            }
        }
        this.librosFacade.edit(libro);
    }

    @Override
    public void remove(Integer id) throws LibroNotFoundException {
        Libros libro = this.find(id);
        this.remove(libro);
    }

    @Override
    public void remove(Libros libro) throws LibroNotFoundException {
        Libros l = this.find(libro.getLibrosPK().getId());
        this.librosFacade.remove(l);
    }

    @Override
    public Libros find(Integer id) throws LibroNotFoundException {
        Libros libro = this.librosFacade.find(id);
        if (libro == null) {
            throw new LibroNotFoundException();
        }
        return libro;
    }

    @Override
    public List<Libros> findAll() {
        return this.librosFacade.findAll();
    }

    @Override
    public List<Libros> findRange(int[] range) {
        return this.librosFacade.findRange(range);
    }

    @Override
    public int count() {
        return this.librosFacade.count();
    }

    @Override
    public List<Libros> findByAutores(Autores autor) {
        return this.librosFacade.findByAutores(autor);
    }

    @Override
    public List<Libros> findByEditorial(Editoriales editorial) {
        return this.librosFacade.findByEditorial(editorial);
    }

    @Override
    public List<Libros> findByNoPaginas(Integer paginas) {
        return this.librosFacade.findByNoPaginas(paginas);
    }

    @Override
    public List<Libros> findByTitulo(String titulo) {
        return this.librosFacade.findByTitulo(titulo);
    }

    @Override
    public List<Libros> findByEdicion(String edicion) {
        return this.librosFacade.findByEdicion(edicion);
    }
}
