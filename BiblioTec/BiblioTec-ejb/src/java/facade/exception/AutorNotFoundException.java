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
public class AutorNotFoundException extends Exception {

    public AutorNotFoundException() {
        super("No se encontro el autor");
    }

    public AutorNotFoundException(String mensaje) {
        super(mensaje);
    }

}
