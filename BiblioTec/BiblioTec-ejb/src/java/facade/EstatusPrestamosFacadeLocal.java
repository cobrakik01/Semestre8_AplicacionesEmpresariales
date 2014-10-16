/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.EstatusPrestamos;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author cobrakik
 */
@Local
public interface EstatusPrestamosFacadeLocal {

    void create(EstatusPrestamos estatusPrestamos);

    void edit(EstatusPrestamos estatusPrestamos);

    void remove(EstatusPrestamos estatusPrestamos);

    EstatusPrestamos find(Object id);

    List<EstatusPrestamos> findAll();

    List<EstatusPrestamos> findRange(int[] range);

    int count();
    
}
