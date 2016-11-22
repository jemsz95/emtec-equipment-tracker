/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Entities.Device;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONArray;

/**
 *
 * @author bryanrosales
 */
public class DevicesInterface extends HttpServlet{
    ///Redirects  GET requests to POST
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException { 
        
        String deviceName = request.getParameter("deviceName");

        Device device = new Device();
        JSONArray result = device.searchDevice(deviceName);
        
        if(!result.isEmpty()){
            
        }else{
            
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {

    String deviceName = request.getParameter("deviceName");

    Device device = new Device();
    boolean result = device.registerDevice(deviceName);
    
    if(result){
        //El equipo fue registrado.
    }else{
        
    }
                        
    }   
    
    protected void doPut(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {

    int idDevice = Integer.parseInt(request.getParameter("idDevice"));
    String deviceName = request.getParameter("deviceName");

    Device device = new Device();
    boolean result = device.updateDevice(idDevice, deviceName);
   
    if(result){
        //El equipo fue actualizado.
    }else{
        
    }
                        
    }
    
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {

    int idDevice = Integer.parseInt(request.getParameter("idDevice"));

    Device device = new Device();
    boolean result = device.deleteDevice(idDevice);
    
    if(result){
        //El equipo fue borrado.
    }else{
        
    }
                        
    }
    
    
}
