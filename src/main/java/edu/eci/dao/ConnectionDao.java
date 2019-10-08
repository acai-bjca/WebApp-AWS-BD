package edu.eci.dao;

import edu.eci.model.Pet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ConnectionDao {

    Connection con = null;

    public Connection RetriveConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String dbName = "bd2";
            String userName = "root";
            String password = "amalia123";
            String hostname = "instancia1.ceh1r5gbitwq.us-east-1.rds.amazonaws.com";
            String port = "3306";
            String jdbcUrl = "jdbc:mysql://" + hostname + ":" + port + "/" + dbName + "?user=" + userName + "&password=" + password;
            String jdbcUrl2 = "jdbc:mysql://" + hostname + ":" + port;

            //con = DriverManager.getConnection("jdbc:mysql://instanciadb.ceh1r5gbitwq.us-east-1.rds.amazonaws.com:3306/user", "root", "amalia123");
            con = DriverManager.getConnection(jdbcUrl);
            System.out.println("Se conectó a la base de datos.");
        } catch (Exception e) {
            System.out.println("No se conectó a la base de datos."+ e);
        }
        return con;
    }

    public List<Pet> getPetList(Connection conn) {
        if (conn == null) {
            conn = RetriveConnection();
        }
        List<Pet> petList = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from mascotas");
            while (rs.next()) {
                Pet pet = new Pet(rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5));
                petList.add(pet);
            }
            System.out.println("list is: " + petList.size());
        } catch (Exception e) {
            e.printStackTrace();
        }      
        return petList;
        //con.close();  
    }
    
    public void savePet(Connection conn, Pet pet) {
        if (conn == null) {
            conn = RetriveConnection();
        }
        
        try {
            Statement stmt = conn.createStatement();
            String values = "'"+pet.getName()+"','"+pet.getOwner()+"',"+pet.getAge()+",'"+pet.getPhone()+"'";
            stmt.executeUpdate("INSERT INTO mascotas (nombre, responsable, edad, celular) VALUES ("+values+")");
            System.err.println("Se guardó");
        } catch (Exception e) {
            System.err.println("No se guardó");
            e.printStackTrace();
        } 
    }
}
