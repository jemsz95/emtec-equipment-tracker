package Interfaces;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

public class EquipmentInterface extends HttpServlet {
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    PrintWriter out = response.getWriter();
    out.println("Hello!");
  }

}
