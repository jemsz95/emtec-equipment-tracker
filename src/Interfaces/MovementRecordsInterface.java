/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Entities.Device;
import Entities.MovementRecord;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author bryanrosales
 */
public class MovementRecordsInterface extends HttpServlet{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {

    int idDevice = Integer.parseInt(request.getParameter("idDevice"));
    int idEquipment = Integer.parseInt(request.getParameter("idEquipment"));
    String locationName = request.getParameter("locationName");
    String date = request.getParameter("date");
    String time = request.getParameter("time");
    
    MovementRecord movementRecord = new MovementRecord();
    boolean result = movementRecord.registerMovement(idDevice, idEquipment, locationName, date, time);
    
    if(result){
        //El equipo fue registrado.
    }else{
        
    }
                        
    }
}
