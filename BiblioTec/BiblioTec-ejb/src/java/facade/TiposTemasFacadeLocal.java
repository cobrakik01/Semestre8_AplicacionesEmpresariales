/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.TiposTemas;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author cobrakik
 */
@Local
public interface TiposTemasFacadeLocal {

    void create(TiposTemas tiposTemas);

    void edit(TiposTemas tiposTemas);

    void remove(TiposTemas tiposTemas);

    TiposTemas find(Object id);

    List<TiposTemas> findAll();

    List<TiposTemas> findRange(int[] range);

    int count();
    
}
