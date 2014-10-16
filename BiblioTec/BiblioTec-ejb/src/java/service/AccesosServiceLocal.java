/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Accesos;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author cobrakik
 */
@Local
public interface AccesosServiceLocal {

    void create(Accesos accesos);

    void edit(Accesos accesos);

    void remove(Accesos accesos);

    Accesos find(Integer id);

    List<Accesos> findAll();

    List<Accesos> findRange(int[] range);

    int count();

    public Accesos findByName(String usuario);
}
