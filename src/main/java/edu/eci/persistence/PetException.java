/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.persistence;

/**
 *
 * @author cristian
 */
public class PetException extends Exception{

    public PetException(String message) {
        super(message);
    }

    public PetException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
