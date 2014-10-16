/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.EditorialesRs;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author cobrakik
 */
@Local
public interface EditorialesRsFacadeLocal {

    void create(EditorialesRs editorialesRs);

    void edit(EditorialesRs editorialesRs);

    void remove(EditorialesRs editorialesRs);

    EditorialesRs find(Object id);

    List<EditorialesRs> findAll();

    List<EditorialesRs> findRange(int[] range);

    int count();
    
}
