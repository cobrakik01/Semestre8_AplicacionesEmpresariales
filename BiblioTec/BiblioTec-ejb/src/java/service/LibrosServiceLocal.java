/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Autores;
import entity.Editoriales;
import entity.Libros;
import facade.exception.AutorNotFoundException;
import facade.exception.EditorialNotFoundException;
import facade.exception.LibroNotFoundException;
import facade.exception.LibroRepeatException;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author cobrakik
 */
@Local
public interface LibrosServiceLocal {

    void create(Libros libro, Integer autorId, Integer editorialId) throws LibroRepeatException, AutorNotFoundException, EditorialNotFoundException;

    void create(Libros libro) throws LibroRepeatException, AutorNotFoundException, EditorialNotFoundException;

    void edit(Libros libro) throws LibroRepeatException, LibroNotFoundException;
    
    void remove(Integer id) throws LibroNotFoundException;

    void remove(Libros libro) throws LibroNotFoundException;

    Libros find(Integer id) throws LibroNotFoundException;

    List<Libros> findAll();

    List<Libros> findRange(int[] range);

    int count();

    List<Libros> findByAutores(Autores autor);

    List<Libros> findByEditorial(Editoriales editorial);

    List<Libros> findByNoPaginas(Integer paginas);

    List<Libros> findByTitulo(String titulo);

    List<Libros> findByEdicion(String edicion);
}
