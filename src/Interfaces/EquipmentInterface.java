/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Entities.Equipment;
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
public class EquipmentInterface extends HttpServlet{
    ///Redirects  GET requests to POST
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException { 
        
        String equipmentName = request.getParameter("equipmentName");

        Equipment equipment = new Equipment();
        JSONArray result = equipment.searchEquipment(equipmentName);
        
        if(!result.isEmpty()){
            
        }else{
            
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {

    String equipmentName = request.getParameter("equipmentName");
    String equipmentCategory = request.getParameter("equipmentCategory");

    Equipment equipment = new Equipment();
    boolean result = equipment.registerEquipment(equipmentName,equipmentCategory);
    
    if(result){
        //El equipo fue registrado.
    }else{
        
    }
                        
    }   
    
    protected void doPut(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {

    int idEquipment = Integer.parseInt(request.getParameter("idEquipment"));
    String equipmentName = request.getParameter("equipmentName");

    Equipment equipment = new Equipment();
    boolean result = equipment.updateEquipment(idEquipment, equipmentName);
   
    if(result){
        //El equipo fue actualizado.
    }else{
        
    }
                        
    }
    
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {

    int idEquipment = Integer.parseInt(request.getParameter("idEquipment"));

    Equipment equipment = new Equipment();
    boolean result = equipment.deleteEquipment(idEquipment);
    
    if(result){
        //El equipo fue borrado.
    }else{
        
    }
                        
    }
    
    
}
