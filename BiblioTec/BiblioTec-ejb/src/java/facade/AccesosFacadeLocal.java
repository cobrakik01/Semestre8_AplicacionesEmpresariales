/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.Accesos;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author cobrakik
 */
@Local
public interface AccesosFacadeLocal {

    void create(Accesos accesos);

    void edit(Accesos accesos);

    void remove(Accesos accesos);

    Accesos find(Object id);

    List<Accesos> findAll();

    List<Accesos> findRange(int[] range);

    int count();

    public Accesos findByName(String nombre);
    
}
