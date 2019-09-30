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
public class PetPersistenceException extends Exception{

    public PetPersistenceException(String message) {
        super(message);
    }

    public PetPersistenceException(String message, Throwable cause) {
        super(message, cause);
    } 
    
}
