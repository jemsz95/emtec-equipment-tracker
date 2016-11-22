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
    
    public void register(int idEquipment, String equipmentComment) {
        try {
            String query = "INSERT INTO Report (idEquipment, equipmentComment) VALUES (?,?)";
            pstmt = con.prepareStatement(query);
            pstmt.setInt(1, idEquipment);
            pstmt.setString(2, equipmentComment);
            pstmt.execute();
        } catch (SQLException e){
            System.out.println ("Can't execute register(idEquipment, equipmentComment)" + e);
        }
    }
    /*
    public static void main(String[] args) {
        Report rp = new Report();
        rp.register(1,"This equipment is failing");   
    }
    */
}

    
