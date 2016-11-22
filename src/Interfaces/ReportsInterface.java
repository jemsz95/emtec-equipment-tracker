/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Entities.Device;
import Entities.Report;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author bryanrosales
 */
public class ReportsInterface extends HttpServlet{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {

    int idEquipment = Integer.parseInt(request.getParameter("idEquipment"));
    String equipmentComment = request.getParameter("equipmentComment");

    Report report = new Report();
    boolean result = report.register(idEquipment,equipmentComment);
    
    if(result){
        //El equipo fue registrado.
    }else{
        
    }
                        
    }
    
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {

    int idReport = Integer.parseInt(request.getParameter("idReport"));

    Report report = new Report();
    boolean result = report.deleteReport(idReport);
    
    if(result){
        //El equipo fue borrado.
    }else{
        
    }
                        
    }
}
