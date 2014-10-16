/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.EstatusCarreras;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author cobrakik
 */
@Local
public interface EstatusCarrerasFacadeLocal {

    void create(EstatusCarreras estatusCarreras);

    void edit(EstatusCarreras estatusCarreras);

    void remove(EstatusCarreras estatusCarreras);

    EstatusCarreras find(Object id);

    List<EstatusCarreras> findAll();

    List<EstatusCarreras> findRange(int[] range);

    int count();
    
}
