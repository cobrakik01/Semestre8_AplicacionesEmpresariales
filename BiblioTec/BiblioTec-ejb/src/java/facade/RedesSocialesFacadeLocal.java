/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.RedesSociales;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author cobrakik
 */
@Local
public interface RedesSocialesFacadeLocal {

    void create(RedesSociales redesSociales);

    void edit(RedesSociales redesSociales);

    void remove(RedesSociales redesSociales);

    RedesSociales find(Object id);

    List<RedesSociales> findAll();

    List<RedesSociales> findRange(int[] range);

    int count();
    
}
