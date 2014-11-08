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
public class LibroRepeatException extends Exception {

    public LibroRepeatException() {
        super("Ya existe un libro con el mismo identificador.");
    }

    public LibroRepeatException(String mensaje) {
        super(mensaje);
    }
    
}
