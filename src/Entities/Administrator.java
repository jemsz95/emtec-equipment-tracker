/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import Support.DBHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author bryanrosales
 */
public class Administrator extends User {
    private PreparedStatement pstmt;
    private DBHelper dbHelper;
    private Connection con ;
    
    public Administrator(){
        dbHelper = new DBHelper();
        dbHelper.dbConnect();
        con = dbHelper.getdbConnection();
    }
  
    public boolean authenticate(String userName , String password){
        try {
            String query = "SELECT id FROM User WHERE userName = (?) and password = (?)";
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, userName);
            pstmt.setString(2, password);
            ResultSet rs =  pstmt.executeQuery();
            System.out.println(rs);
            //No hago la validacion pero si retorna vacio el array es false;
            return true;
        } catch (SQLException e){
          System.out.println("Can't execute authenticate() to table User" + e);
        }
    
        return false;
    }

    public void registerAdmin(String firstName,String lastName, String userName, String password){
        try {
            String query = "INSERT INTO User (firstName, lastName, userName, password) VALUES (?,?,?,?)";
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, firstName);
            pstmt.setString(2, lastName);
            pstmt.setString(3, userName);
            pstmt.setString(4, password);
            pstmt.execute();
        } catch (SQLException e){
            System.out.println("Can't execute registerAdmin() to table User" + e);
        }
    }
    
    public static void main(String[] args) {
        Administrator ad = new Administrator();
        //ad.registerAdmin("luis","bryan","vampbryan","1234");
        ad.authenticate("vampbryan", "1234");
    }
       
}
