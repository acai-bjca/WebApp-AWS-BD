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
@RequestMapping()
public class PetAPIController {
    //static ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
    @Autowired
    PetServices petService;

    
    @RequestMapping(value = "/pets", method = RequestMethod.GET)
    public ResponseEntity<List<Pet>> manejadorGetRecursoMascotas() throws ResourceNotFoundException {
        System.out.println("Entro al GET");
        List<Pet> data;
        try {
            data = petService.getAllPets();
            return new ResponseEntity<>(data, HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            throw new ResourceNotFoundException(ex.getMessage());
        }
    }
    
    @RequestMapping(value = "/pet/", method = RequestMethod.GET)
    public ResponseEntity<List<Pet>> listAllUsers() {
        List<Pet> pets = petService.getAllPets();
        if(pets.isEmpty()){
            return new ResponseEntity<List<Pet>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Pet>>(pets, HttpStatus.OK);
    } 
       

    @RequestMapping("/{name}")
    public HttpEntity getAddressName(@PathVariable String name) {
        try {
            // obtener datos que se enviarán a través del API
            Object data = petService.getPetByName(name);

            return new ResponseEntity<>(data, HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(PetAPIController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error Mascota no encontrada", HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/{petName}")
    public ResponseEntity<?> manejadorPostRecursoCinema(@RequestBody Pet pet, @PathVariable String petName) {
        try {
            petService.addNewPet(pet);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception ex) {
            Logger.getLogger(PetAPIController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("No fue posible crear el recurso", HttpStatus.FORBIDDEN);
        }
    }
}
