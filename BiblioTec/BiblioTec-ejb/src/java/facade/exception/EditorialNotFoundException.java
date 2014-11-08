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
public class EditorialNotFoundException extends Exception {

    public EditorialNotFoundException() {
        super("No se encontro la editorial");
    }

    public EditorialNotFoundException(String mensaje) {
        super(mensaje);
    }
    
}
