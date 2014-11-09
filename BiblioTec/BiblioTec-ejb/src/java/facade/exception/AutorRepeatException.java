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
public class AutorRepeatException extends Exception {

    public AutorRepeatException() {
        super("Ya existe un autor con el mismo identificador.");
    }

    public AutorRepeatException(String message) {
        super(message);
    }

}
