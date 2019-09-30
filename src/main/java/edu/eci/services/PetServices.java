package edu.eci.services;

import edu.eci.dao.ConnectionDao;
import edu.eci.model.Pet;
import edu.eci.persistence.*;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PetServices{    
    private static List<Pet> pets;
    
    @Autowired
    PetPersistence persistence;
    ConnectionDao connDao = new ConnectionDao();
    Connection conn = null;

    public void getConnection() {
        conn = connDao.RetriveConnection();
        pets = connDao.getPetList(conn);
    }

    public void addNewPet(Pet pet) throws PetException {
        try {
            persistence.savePet(pet);
        } catch (PetPersistenceException e) {
            throw new PetException(e.getMessage(), e);
        }
    }
    
    public List<Pet> getAllPets() {
        connDao.RetriveConnection();
        /*HashMap<String, Pet> petsH = persistence.getPets();
        List<Pet> pets = new ArrayList<>();
        for (String key : petsH.keySet()) {
            pets.add(petsH.get(key));
        }*/
        List<Pet> pets = connDao.getPetList(conn);
        return pets;
    }

    public Pet getPetByName(String name) throws PetException {
        try {
            return persistence.getPetByName(name);
        } catch (PetPersistenceException e) {
            throw new PetException(e.getMessage(), e);
        }
    }
}
