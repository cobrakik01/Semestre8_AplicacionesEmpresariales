/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Autores;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author cobrakik
 */
@Local
public interface AutoresServiceLocal {

    void create(Autores autores);

    void edit(Autores autores);

    void remove(Autores autores);

    Autores find(Integer id);

    List<Autores> findAll();

    List<Autores> findRange(int[] range);

    int count();

    List<Autores> findByApp(String app);

    List<Autores> findByApm(String apm);

    List<Autores> findByAlias(String alias);

    List<Autores> findByPages(Integer pages);

    Autores findByEmail(String email) throws Exception;
    
}
