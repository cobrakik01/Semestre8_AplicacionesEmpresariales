/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Autores;
import facade.exception.AutorNotFoundException;
import facade.exception.AutorRepeatException;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author cobrakik
 */
@Local
public interface AutoresServiceLocal {

    void create(Autores autores) throws AutorRepeatException;

    void edit(Autores autores) throws AutorRepeatException, AutorNotFoundException;

    void remove(Autores autores);

    Autores find(Integer id) throws AutorNotFoundException;

    List<Autores> findAll();

    List<Autores> findRange(int[] range);

    int count();

    List<Autores> findByApp(String app) throws AutorNotFoundException;

    List<Autores> findByApm(String apm) throws AutorNotFoundException;

    List<Autores> findByAlias(String alias) throws AutorNotFoundException;

    List<Autores> findByPages(Integer pages) throws AutorNotFoundException;

    Autores findByEmail(String email) throws AutorNotFoundException;

    boolean exist(Autores autor);

}
