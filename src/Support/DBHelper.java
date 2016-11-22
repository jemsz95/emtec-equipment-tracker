/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Support;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bryanrosales
 */
public class DBHelper {
    private Connection dbConnection;
    
    public void DBHelper(){
        
    }   
    
    public void dbConnect(){
        String url = "jdbc:mysql://localhost:3306/AMS";
        String username = "amss";
        String password = "emtec";
        
        System.out.println("Connecting database...");

        try {
            dbConnection = DriverManager.getConnection(url, username, password);
            System.out.println("Database connected!");

        } catch (SQLException ex) {
            System.out.println("Cannot connect the database!");
            Logger.getLogger(DBHelper.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }
    
    public Connection getdbConnection(){
        return this.dbConnection;
    }
}
