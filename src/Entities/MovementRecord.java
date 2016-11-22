/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import Support.DBHelper;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author bryanrosales
 */
public class MovementRecord {
    private Date lastSeen;
    private int id;
    private PreparedStatement pstmt;
    private DBHelper dbHelper;
    private Connection con ;

    public MovementRecord(){
        dbHelper = new DBHelper();
        dbHelper.dbConnect();
        con = dbHelper.getdbConnection();
    }
    
    //Date format dd/mm/yyyy
    //Time 12:00 (hr.min)
    public boolean registerMovement(int idDevice, int idEquipment, String locationName, String date, String time){
        boolean result = false;
        try{ 
            String query = "INSERT INTO MovementRecord (idDevice, idEquipment, locationName, date, time) Values (?,?,?,?,?)";
            pstmt = con.prepareStatement(query);
            pstmt.setInt(1, idDevice);
            pstmt.setInt(2, idEquipment);
            pstmt.setString(3, locationName);
            pstmt.setString(4, date);
            pstmt.setString(5, time);
            pstmt.execute();
            result=true;
        }catch (SQLException e) {
            result=false;
            System.out.println("Can't execute registerMovement() to table MovementRecord" + e);
        }   
        return result;
    }
    
    public static void main(String[] args) {
        MovementRecord mr = new MovementRecord();
        mr.registerMovement(1,1,"bath","13/06/95","12:30");
        
    }
    

}
