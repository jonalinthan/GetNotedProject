/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.User;
import entities.Professor;
import entities.Questionbank;
import java.util.List;
import javax.servlet.RequestDispatcher;
import sessionBean.getNotedSessionBean;
import javax.ejb.EJB;

/**
 *
 * @author quantumDrop
 */
@WebServlet(name = "ListQuestionBankServlet", urlPatterns = {"/ListQuestionBankServlet"})
public class ListQuestionBankServlet extends HttpServlet {
    @EJB getNotedSessionBean getNotedBean;
    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            RequestDispatcher rd = request.getRequestDispatcher("ListQuestionBank.jsp");
            rd.forward(request, response);
            
            Professor p = (Professor)request.getSession().getAttribute("professor");
            List<String> qb = getNotedBean.listQB(p);
            
            //sets the attribute of what we just got
            request.getSession().setAttribute("questionBankquestions", qb);
            
            //rd = request.getRequestDispatcher("questionBank.jsp");
            //pushes you to the file you just dispatched
            //rd.forward(request, response);
        } finally {             
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
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
     * Handles the HTTP
     * <code>POST</code> method.
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
}
