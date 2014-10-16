/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.TiposRenovacion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author cobrakik
 */
@Local
public interface TiposRenovacionFacadeLocal {

    void create(TiposRenovacion tiposRenovacion);

    void edit(TiposRenovacion tiposRenovacion);

    void remove(TiposRenovacion tiposRenovacion);

    TiposRenovacion find(Object id);

    List<TiposRenovacion> findAll();

    List<TiposRenovacion> findRange(int[] range);

    int count();
    
}
