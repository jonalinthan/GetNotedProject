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

/*
 * You have to import these.  Import the entities that are used for each servlet.
 * In this case, we are logging in, so we only have to check User.  So we import
 * User.  Additionally, import the other three because you need all three of them.
 */
import entities.User;
import javax.servlet.RequestDispatcher;
import sessionBean.getNotedSessionBean;
import javax.ejb.EJB;

/**
 *
 * @author Jonathan
 */
public class LoginServlet extends HttpServlet {

    /*
     * Don't forget this line.  Stick with it.  Don't rename it.
     * This is injecting the bean into the servlet.
     */
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
             * Here is where you generate logic for the page.  This is different
             * for every single servlet.
             */
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            
            User user = getNotedBean.checkUser(username, password);
            
            if (user != null) {
                request.getSession().setAttribute("user", user);
                if (user.getUserType().equals("student")) {
                    RequestDispatcher rd = request.getRequestDispatcher("studentPage.jsp");
                    rd.forward(request, response);
                }
                else if (user.getUserType().equals("professor")) {
                    RequestDispatcher rd = request.getRequestDispatcher("professorPage.jsp");
                    rd.forward(request, response);
                }
                else {
                    RequestDispatcher rd = request.getRequestDispatcher("loginFail.jsp");
                    rd.forward(request, response);
                }
            }
            else {
                RequestDispatcher rd = request.getRequestDispatcher("loginFail.jsp");
                rd.forward(request, response);
            }
            
        } catch (Exception e) {
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
