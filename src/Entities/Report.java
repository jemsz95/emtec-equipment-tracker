/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import Support.DBHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author bryanrosales
 */
public class Report {
    private int id;
    private String content;
    private Equipment equipment;
    private PreparedStatement pstmt;
    private DBHelper dbHelper;
    private Connection con ;

    public Report(){
        dbHelper = new DBHelper();
        dbHelper.dbConnect();
        con = dbHelper.getdbConnection();
    }
    
    public boolean register(int idEquipment, String equipmentComment) {
        boolean result=false;
        try {
            String query = "INSERT INTO Report (idEquipment, equipmentComment) VALUES (?,?)";
            pstmt = con.prepareStatement(query);
            pstmt.setInt(1, idEquipment);
            pstmt.setString(2, equipmentComment);
            pstmt.execute();
            result=true;
        } catch (SQLException e){
            result=false;
            System.out.println ("Can't execute register(idEquipment, equipmentComment)" + e);
        }
        return result;
    }
    
    public boolean deleteReport(int idReport){
        boolean success=false;
        try{
            String query = "DELETE FROM Report WHERE id = (?)";
            pstmt = con.prepareStatement(query);
            pstmt.setInt(1, idReport);
            pstmt.execute();
            success=true;
        } catch (SQLException e) {
            success=false;
            System.out.println("Can't execute deleteReport() to table Equipment" + e);
        }
        return success;
    }
    
    
    public static void main(String[] args) {
        Report rp = new Report();
        rp.register(1,"This equipment is failing");   
    }
}

    
