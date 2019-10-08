/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.controller;

import edu.eci.model.Pet;
import edu.eci.services.PetServices;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/pets")
public class PetAPIController {
    //static ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
    @Autowired
    PetServices petService;

    
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Pet>> manejadorGetRecursoMascotas() throws ResourceNotFoundException {
        System.out.println("Entro al GET");
        List<Pet> data = null;
        try {
            data = petService.getAllPets();
            for(int i=0; i <data.size(); i++){
                System.out.println(data.get(i).getName());
            }
            return new ResponseEntity<List<Pet>>(data, HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            throw new ResourceNotFoundException(ex.getMessage());
        }
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Pet> manejadorPostRecursoCinema(@RequestBody Pet pet) throws ResourceNotFoundException {
        System.out.println("Entro al POST");
        try {
            petService.addNewPet(pet);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception ex) {            
            //return new ResponseEntity<?>("No fue posible crear el recurso", HttpStatus.FORBIDDEN);
            throw new ResourceNotFoundException(ex.getMessage());
        }
    }    
}
