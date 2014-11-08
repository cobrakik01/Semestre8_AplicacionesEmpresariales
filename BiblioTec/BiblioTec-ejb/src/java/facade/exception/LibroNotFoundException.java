/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade.exception;

/**
 *
 * @author cobrakik
 */
public class LibroNotFoundException extends Exception {

    public LibroNotFoundException() {
        super("No se encontro el libro");
    }
    
}
