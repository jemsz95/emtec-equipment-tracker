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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;

/**
 *
 * @author bryanrosales
 */
public class Device {
    private String deviceName;
    private int deviceId;
    private PreparedStatement pstmt;
    private DBHelper dbHelper;
    private Connection con ;

    public Device(){
        dbHelper = new DBHelper();
        dbHelper.dbConnect();
        con = dbHelper.getdbConnection();
    }
    
    public boolean registerDevice(String deviceName){
        boolean result = false;
        try{
            String query = "INSERT INTO Device (name) VALUES (?)";
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, deviceName);
            pstmt.execute();
            result=true;
        } catch (SQLException e) {
            result=false;
            System.out.println("Can't execute register() to table Equipment" + e);
        }
        return result;
    }

    public JSONArray searchDevice(String deviceName){
        JSONArray jsonArray = new JSONArray();
        try{
            String query = "SELECT * FROM Device WHERE name = (?) ";
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, deviceName);
            ResultSet rs =  pstmt.executeQuery();
            try {
                System.out.println(ResultSetToJSON.convert(rs).toString());
                jsonArray = ResultSetToJSON.convert(rs);
            } catch (Exception ex) {
                Logger.getLogger(Device.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SQLException e) {
          System.out.println("Can't execute SearchEquipment(String) to table equipment" + e);
        }
        return jsonArray;
    }
    
    public boolean updateDevice(int idDevice, String deviceName){
        boolean success=false;
        try{
            String query = "UPDATE Device SET name = (?) WHERE id = (?) ";
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, deviceName);
            pstmt.setInt(2, idDevice);
            pstmt.execute();
            success=true;
        } catch (SQLException e) {
            success=false;
            System.out.println("Can't execute updateDevice() to table Equipment" + e);
        }
        return success;
    }
    
    public boolean deleteDevice(int idDevice){
        boolean success=false;
        try{
            String query = "DELETE FROM Device WHERE id = (?)";
            pstmt = con.prepareStatement(query);
            pstmt.setInt(1, idDevice);
            pstmt.execute();
            success=true;
        } catch (SQLException e) {
            success=false;
            System.out.println("Can't execute deleteDevice() to table Equipment" + e);
        }
        return success;
    }
    
    public static void main(String[] args) {
        Device dv = new Device();
        //dv.registerDevice("deviceNameTest");
        dv.searchDevice("deviceNameTest");
    }
}
