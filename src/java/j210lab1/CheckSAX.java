/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j210lab1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author User
 */
@WebServlet(name = "CheckSAX", urlPatterns = {"/CheckSAX"})
public class CheckSAX extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        
        String field = request.getParameter("field");
        
        DemoSAX.parseXMLBySAX();
        List<User> users = DemoSAX.getUserList();
        
        String result = getFieldValues(users, field);
        
        request.setAttribute("result", result);
        request.getRequestDispatcher("index.jsp").forward(request, response);
        
//        try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet CheckSAX</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet CheckSAX at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        }
        
        
        
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    
    
    
    private String getFieldValues(List<User> users, String field) {
        StringBuilder sb = new StringBuilder("<h2> Field value " + field + "</h2><ol>"); //ol-order list
        for (User user : users) {
            switch (field) {
                case "id":
                    sb.append("<li>" + user.getId() + "</li>");// </li>" - element spiska
                    break;
                case "role":
                    sb.append("<li>" + user.getRole() + "</li>");
                    break;
                case "first-name":
                    sb.append("<li>" + user.getFirstNmae() + "</li>");
                    break;
                case "family":
                    sb.append("<li>" + user.getFamily() + "</li>");
                    break;
                case "department":
                    sb.append("<li>" + user.getDepartment() + "</li>");
                    break;
                default:
                    return "<h2>Field value " + field + " not found</h2>";
                    
            }
        }
        sb.append("</ol>");
        return sb.toString();
    }

}
