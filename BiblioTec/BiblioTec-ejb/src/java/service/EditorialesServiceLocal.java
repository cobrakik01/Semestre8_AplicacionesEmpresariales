/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Editoriales;
import facade.exception.EditorialNotFoundException;
import facade.exception.EditorialRepeatException;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author cobrakik
 */
@Local
public interface EditorialesServiceLocal {

    void create(Editoriales editoriales) throws EditorialRepeatException;

    void edit(Editoriales editoriales) throws EditorialRepeatException, EditorialNotFoundException;

    void remove(Editoriales editoriales);

    Editoriales find(Object id) throws EditorialNotFoundException;

    List<Editoriales> findAll();

    List<Editoriales> findRange(int[] range);

    int count();
    
    Editoriales findByNombre(String nombre) throws EditorialNotFoundException;
    
    List<Editoriales> findByTelefono(String telefono) throws EditorialNotFoundException;
    
    List<Editoriales> findByDireccion(String direccion) throws EditorialNotFoundException;
    
    List<Editoriales> findByColonia(String colonia) throws EditorialNotFoundException;
    
    List<Editoriales> findByCiudad(String ciudad) throws EditorialNotFoundException;
}
