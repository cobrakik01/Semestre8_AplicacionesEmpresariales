/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.Editoriales;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author cobrakik
 */
@Local
public interface EditorialesFacadeLocal {

    void create(Editoriales editoriales);

    void edit(Editoriales editoriales);

    void remove(Editoriales editoriales);

    Editoriales find(Object id);

    List<Editoriales> findAll();

    List<Editoriales> findRange(int[] range);

    int count();
    
    List<Editoriales> findByNombre(String nombre);
    
    List<Editoriales> findByTelefono(String telefono);
    
    List<Editoriales> findByDireccion(String direccion);
    
    List<Editoriales> findByColonia(String colonia);
    
    List<Editoriales> findByCiudad(String ciudad);
    
}
