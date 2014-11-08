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
import javax.ejb.Local;

/**
 *
 * @author cobrakik
 */
@Local
public interface LibrosFacadeLocal {

    void create(Libros libros);

    void edit(Libros libros);

    void remove(Libros libros);

    Libros find(Object id);

    List<Libros> findAll();

    List<Libros> findRange(int[] range);

    int count();
    
    List<Libros> findByAutores(Autores autor);

    List<Libros> findByEditorial(Editoriales editorial);

    List<Libros> findByNoPaginas(Integer paginas);

    Libros findByIsbn(String isbn);

    List<Libros> findByTitulo(String titulo);

    List<Libros> findByEdicion(String edicion);
    
}
