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

import entities.User;
import entities.Student;
import entities.Professor;
import entities.School;
import entities.Department;
import javax.servlet.RequestDispatcher;
import sessionBean.getNotedSessionBean;
import javax.ejb.EJB;

/**
 *
 * @author Jonathan
 */
public class RegisterServlet extends HttpServlet {

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
            
            String majorID, departmentID = null;
            int yearOfGraduation = 0;
            String slot = getNotedBean.highestSlotAvailable();
            User user = null;
            Student student = null;
            Professor professor = null;
            
            String username = (String) request.getParameter("username");
            String password = (String) request.getParameter("password");
            String firstName = (String) request.getParameter("firstName");
            String lastName = (String) request.getParameter("lastName");
            String schoolID = (String) request.getParameter("school");
            System.out.println(schoolID);
            String email = (String) request.getParameter("email");
            
            String userType = (String) request.getParameter("type");
            
            if (userType.equals("student")) {
                majorID = (String) request.getParameter("major");
                yearOfGraduation = Integer.parseInt((String)request.getParameter("yearOfGraduation"));
            
                School school = getNotedBean.getSchool(schoolID);
                String schoolName = (String) school.getNameOfSchool();
                
                Department dept = getNotedBean.getDepartment(majorID);
                String major = dept.getDepartmentName();
                
                user = new User();
                student = new Student();
                
                user.setUserID(slot);
                user.setUsername(username);
                user.setPassword(password);
                user.setFirstName(firstName);
                user.setLastName(lastName);
                user.setSchool(schoolName);
                user.setEmail(email);
                user.setUserType("student");
                student.setMajor(major);
                student.setYearOfGraduation(yearOfGraduation);
                student.setUserID(user.getUserID());
                
                getNotedBean.saveUser(user);
                getNotedBean.saveStudent(student);
            }
            else if (userType.equals("professor")) {
                departmentID = (String) request.getParameter("department");
                
                School school = getNotedBean.getSchool(schoolID);
                String schoolName = (String) school.getNameOfSchool();
                
                Department dept = getNotedBean.getDepartment(departmentID);
                String departmentName = dept.getDepartmentName();
                
                user = new User();
                professor = new Professor();
                
                user.setUserID(slot);
                user.setUsername(username);
                user.setPassword(password);
                user.setFirstName(firstName);
                user.setLastName(lastName);
                user.setSchool(schoolName);
                user.setUserType("professor");
                user.setEmail(email);
                professor.setProfessorID(user.getUserID());
                professor.setDepartment(departmentName);
                
                getNotedBean.saveUser(user);
                getNotedBean.saveProfessor(professor);
            }
            
            
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
