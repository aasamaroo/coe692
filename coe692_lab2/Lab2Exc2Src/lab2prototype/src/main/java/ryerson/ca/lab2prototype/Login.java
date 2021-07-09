/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ryerson.ca.lab2prototype;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author student
 */
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

 

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
        doPost(request, response);
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
        
       
       String email = (String) request.getParameter("email");
       String password = (String) request.getParameter("password");
       
       Member m = getMember(email, password);
       
       if(m == null){
           RequestDispatcher rd = request.getRequestDispatcher("index.html");
           rd.forward(request, response);
       }else{
           request.getSession().setAttribute("email", email);
           request.getSession().setAttribute("password", password);
           ArrayList<Chat> chats = m.getChats();
           request.getSession().setAttribute("listOfChats", chats);
           
           RequestDispatcher rd = request.getRequestDispatcher("jsp/welcome.jsp");
           rd.forward(request, response);
       }
    }
    

    private Member getMember(String email, String password){
        Member m = new Member();
        try{
            m.createChat("Friends");
            m.createChat("Work");
        }catch (Exception e){
            System.out.println("Error");
        }
        return m;
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

}
