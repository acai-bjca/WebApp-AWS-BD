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
            String dbName = System.getenv("db1");
            String userName = System.getenv("root");
            String password = System.getenv("amalia123");
            String hostname = System.getenv("instanciadb.ceh1r5gbitwq.us-east-1.rds.amazonaws.com");
            String port = System.getenv("3306");
            String jdbcUrl = "jdbc:mysql://" + hostname + ":" + port + "/" + dbName + "?user=" + userName + "&password=" + password;

            //con = DriverManager.getConnection("jdbc:mysql://awsrds.cuaofirbrh2o.us-west-2.rds.amazonaws.com:3306/user", "username", "password");
            con = DriverManager.getConnection(jdbcUrl);
        } catch (Exception e) {
            System.out.println(e);
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
                Pet pet = new Pet(rs.getString(1),rs.getString(2),rs.getInt(3),String.valueOf(rs.getInt(4)));
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
            String values = "'"+pet.getName()+"','"+pet.getOwner()+"',"+pet.getAge()+","+pet.getPhone();
            stmt.executeUpdate("INSERT INTO mascotas (nombre, responsable, edad, celular) VALUES ("+values+")");
            //ResultSet rs = stmt.executeQuery("INSERT INTO mascotas (nombre, responsable, edad, celular) VALUES ("+values+")");            
        } catch (Exception e) {
            e.printStackTrace();
        }
        //con.close();  
    }
}
