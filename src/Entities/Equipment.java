/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import Support.DBHelper;
import Support.ResultSetToJSON;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import org.json.simple.JSONArray;


/**
 *
 * @author bryanrosales
 */
public class Equipment {
    private String equipmentName;
    private int equipmentID;
    private PreparedStatement pstmt;
    private DBHelper dbHelper;
    private Connection con ;
    
    public Equipment(){
        dbHelper = new DBHelper();
        dbHelper.dbConnect();
        con = dbHelper.getdbConnection();
    }
    
    public void registerEquipment(String equipmentName){
        try{
            String query = "INSERT INTO Equipment (name) VALUES (?)";
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, equipmentName);
            pstmt.execute();
        } catch (SQLException e) {
            System.out.println("Can't execute register() to table Equipment" + e);
        }
    }

    public JSONArray searchEquipment(String equipmentName){
        JSONArray jsonArray = new JSONArray();
        try{
            String query = "SELECT * FROM Equipment WHERE name = (?) ";
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, equipmentName);
            ResultSet rs =  pstmt.executeQuery();
            System.out.println(ResultSetToJSON.convert(rs).toString());
            jsonArray = ResultSetToJSON.convert(rs);
        } catch (SQLException e) {
          System.out.println("Can't execute SearchEquipment(String) to table equipment" + e);
        }
        return jsonArray;
    }
    /* 
    public static void main(String[] args) {
        Equipment eq = new Equipment();
        eq.searchEquipment("equipmentTestName1");
        
    }
    */
}
