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
public class EditorialRepeatException extends Exception {

    public EditorialRepeatException() {
        super("Ya existe una editorial con el mismo identificador.");
    }

    public EditorialRepeatException(String message) {
        super(message);
    }

}
