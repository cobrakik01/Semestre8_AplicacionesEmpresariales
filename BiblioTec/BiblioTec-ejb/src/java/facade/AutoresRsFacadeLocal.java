/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.AutoresRs;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author cobrakik
 */
@Local
public interface AutoresRsFacadeLocal {

    void create(AutoresRs autoresRs);

    void edit(AutoresRs autoresRs);

    void remove(AutoresRs autoresRs);

    AutoresRs find(Object id);

    List<AutoresRs> findAll();

    List<AutoresRs> findRange(int[] range);

    int count();
    
}
