package edu.eci.services;

import edu.eci.dao.ConnectionDao;
import edu.eci.model.Pet;
import edu.eci.persistence.*;
import java.sql.Connection;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class PetServices {
    private static List<Pet> pets;
    ConnectionDao connDao = new ConnectionDao();
    Connection conn = null;

    public void getConnection() {
        conn = connDao.RetriveConnection();
        pets = connDao.getPetList(conn);
    }

    public void addNewPet(Pet pet) throws PetException {        
        connDao.RetriveConnection();
        connDao.savePet(conn, pet);

    }

    public List<Pet> getAllPets() {
        System.out.println("edu.eci.services.PetServices.getAllPets()");
        connDao.RetriveConnection();
        List<Pet> pets = connDao.getPetList(conn);
        return pets;
    }
}
