package edu.eci.persistence;

import edu.eci.model.Pet;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author cristian
 */

@Service
public class PetPersistence {
    private final HashMap<String, Pet> pets = new HashMap<>();

    public PetPersistence() {
        // load stub data
        String name1 = "Dofy";  
        String name2 = "Charlie";  
        String owner1 = "Amalia";  
        String owner2 = "Amalia";  
        int age1 = 12;  
        int age2 = 1;
        String phone1 = "0123456789";
        String phone2 = "0123456789"; 
        
        Pet pet1 = new Pet(name1, owner1, age1, phone1);
        Pet pet2 = new Pet(name2, owner2, age2, phone2);
        pets.put(name1, pet1);
        pets.put(name2, pet2);  
    }

    public void savePet(Pet pet) throws PetPersistenceException {

        if (pet.containsKey(pet.getName())) {

            throw new PetPersistenceException("The given pet already exists: " + pet.getName());
        } else {
            pets.put(pet.getName(), pet);
        }
    }

    public Pet getPetByName(String name) throws PetPersistenceException {
        if (pets.get(name) == null)
            throw new PetPersistenceException("pet not found");
        return pets.get(name);
    }

    public HashMap<String, Pet> getPets() {
        return this.pets;
    }
}
