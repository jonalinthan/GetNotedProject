/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import entities.School;
import entities.Department;
import javax.servlet.RequestDispatcher;
import sessionBean.getNotedSessionBean;
import javax.ejb.EJB;

/**
 *
 * @author Jonathan
 */
public class GenerateSchoolAndMajorServlet extends HttpServlet {

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
            /*
             * TODO output your page here. You may use following sample code.
             */
            School[] schools = getNotedBean.generateSchoolArray();
            //String[] schoolIDs = getNotedBean.generateSchoolIDArray();
            Department[] departments = getNotedBean.generateDepartmentArray();
            //String[] departmentIDs = getNotedBean.generateDepartmentIDArray();
            
            request.getSession().setAttribute("schools", schools);
            //request.getSession().setAttribute("schoolIDs", schoolIDs);
            //request.getSession().setAttribute("schoolCount", schools.length);
            request.getSession().setAttribute("majors", departments);
            //request.getSession().setAttribute("majorIDs", departmentIDs);
            //request.getSession().setAttribute("departmentCount", departments.length);
            
            RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
            rd.forward(request, response);
            
        } 
        
        catch (Exception e) {
            out.println("Error.");
            out.println("<FORM><INPUT TYPE='button' VALUE='Back' onClick='history.go(-1);return true;'></FORM>");
            out.println("<br/> "+e.toString());
        }
        
        finally {            
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
