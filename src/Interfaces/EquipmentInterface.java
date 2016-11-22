package Interfaces;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

import Entities.Equipment;

public class EquipmentInterface extends HttpServlet {
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    Equipment e = new Equipment();

    //e.registerEquipment("Camilla");

    PrintWriter out = response.getWriter();
    //out.println(e.searchEquipment("Camilla"));
    out.println("Hola!");
  }

}
