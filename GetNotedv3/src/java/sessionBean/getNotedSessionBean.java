/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBean;

import entities.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.*;
import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

/**
 *
 * @author Jonathan
 */
@Stateless
@LocalBean
public class getNotedSessionBean {

    @PersistenceUnit
    EntityManagerFactory emf;
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    public User checkUser(String username, String password) {
        String query = "SELECT userID FROM User WHERE username='" + username + "'";
        List<String> temp = emf.createEntityManager().createNativeQuery(query).getResultList();
            if (temp.size() <= 0)
                return null;
        User user = (User) emf.createEntityManager().find(User.class, temp.get(0));
        if (user != null) { 
            if (user.getPassword().equals(password)) {
                return user;
            }
            else {
                return null;
            }
        }
        else {
            return null;
        }
    }
     public void registerUser(HttpServletRequest request){
       String userAt[] = {"username", "password","firstName","lastName", "email","school"};
            String userVal[] = new String[6];
            
            String studentAt[]={"major","yearOfGraduation"};
            String studentVal[]=new String[2];
            String professorAttribute="";
            int i;
            for(i=0; i<userAt.length; i++){
                userVal[i]=request.getParameter(userAt[i]);
            }
            GeneralizedQueries.insert("user", userVal, userAt);
            if((request.getParameter("type")).equals("student")){
                for(i=0; i<studentAt.length; i++) studentVal[i]= request.getParameter(studentAt[i]);
                GeneralizedQueries.insert("student", studentVal, studentAt);

            }
            else{
                professorAttribute= request.getParameter("department");
                String pa[]= {"department"};
                String pv[]= {professorAttribute};
                GeneralizedQueries.insert("professor",pa, pv);
            }
        } 
     
     public School[] generateSchoolArray() {
         /*String query = "SELECT * FROM School ORDER BY nameOfSchool ASC";
         List<School> schoolList = emf.createEntityManager().createNativeQuery(query).getResultList();
         School[] temp = new School[schoolList.size()];
         for (int i = 0; i < temp.length; i++) {
             temp[i] = schoolList.get(i);
         }
         return temp;
         
         TypedQuery<School> query;
         List<School> searchResults = null;;
         //searchResults = emf.createEntityManager().createNativeQuery("SELECT * FROM school s ORDER BY s.nameOfSchool ASC").getResultList();
         
         query = emf.createEntityManager().createQuery("SELECT * FROM School ORDER BY nameOfSchool ASC", School.class);
         searchResults = query.getResultList();
         
         //System.out.println(searchResults.size());
         
         return searchResults.toArray(new School[searchResults.size()]);*/
         List<School> searchResults = new ArrayList();
         List<String> temp = null;
         
         temp = emf.createEntityManager().createNativeQuery("SELECT s.schoolID FROM school s ORDER BY s.nameOfSchool ASC").getResultList();
         for (String i : temp) {
             searchResults.add(getSchool(i));
         }
         
         return searchResults.toArray(new School[searchResults.size()]);
     }
     
     /*
     public School[] generateSchoolIDArray() {
         String query = "SELECT * FROM School ORDER BY nameOfSchool ASC";
         List<School> schoolList = emf.createEntityManager().createNativeQuery(query).getResultList();
         School[] temp = new School[schoolList.size()];
         for (int i = 0; i < temp.length; i++) {
             temp[i] = schoolList.get(i);
         }
         return temp;
         
         List<School> searchResults = new ArrayList();
         String[] schoolIDs;
         
         searchResults = emf.createEntityManager().createNativeQuery("SELECT * FROM school s ORDER BY s.nameOfSchool ASC").getResultList();
         schoolIDs = new String[searchResults.size()];
         
         for (int i = 0; i < schoolIDs.length; i++) {
             schoolIDs[i] = (String) searchResults.get(i).getSchoolID();
         }
         
         return (Sc);
     }
     */
     
     public Department[] generateDepartmentArray() {
         /*String query = "SELECT * FROM Department ORDER BY departmentName ASC";
         List<Department> departmentList = emf.createEntityManager().createNativeQuery(query).getResultList();
         Department[] temp = new Department[departmentList.size()];
         for (int i = 0; i < temp.length; i++) {
             temp[i] = departmentList.get(i);
         }
         return temp;
         
         List<Department> searchResults = new ArrayList();
         searchResults = emf.createEntityManager().createNativeQuery("SELECT * FROM department d ORDER BY d.departmentName ASC").getResultList();
         return (Department[]) searchResults.toArray(new Department[searchResults.size()]);*/
         
         List<Department> searchResults = new ArrayList();
         List<String> temp = null;
         
         temp = emf.createEntityManager().createNativeQuery("SELECT d.departmentID FROM department d ORDER BY d.departmentName ASC").getResultList();
         for (String i : temp) {
             searchResults.add(getDepartment(i));
         }
         
         return searchResults.toArray(new Department[searchResults.size()]);
     }
     
     /*
     public String[] generateDepartmentIDArray() {
         String query = "SELECT * FROM Department ORDER BY departmentName ASC";
         List<Department> departmentList = emf.createEntityManager().createNativeQuery(query).getResultList();
         Department[] temp = new Department[departmentList.size()];
         for (int i = 0; i < temp.length; i++) {
             temp[i] = departmentList.get(i);
         }
         return temp;
         
         List<Department> searchResults = new ArrayList();
         String[] departmentIDs;
         
         searchResults = emf.createEntityManager().createNativeQuery("SELECT * FROM department d ORDER BY d.departmentName ASC").getResultList();
         departmentIDs = new String[searchResults.size()];
         
         for (int i = 0; i < departmentIDs.length; i++) {
             departmentIDs[i] = (String) searchResults.get(i).getDepartmentID();
         }
         
         return departmentIDs;
     }
     */
     
     public void updateSettings(Object object){
         
         emf.createEntityManager().merge(object);
     }
     public Buddies getBuddies(String courseID){
         Buddies us = (Buddies) emf.createEntityManager().find(Buddies.class, courseID);
         if(us!=null){
             return us;
         }
         return null;
     }
     public Course getCourse(String courseID){
         Course us = (Course) emf.createEntityManager().find(Course.class, courseID);
         if(us!=null){
             return us;
         }
         return null;
     }
     public Department getDepartment(String departmentID){
         Department us = (Department) emf.createEntityManager().find(Department.class, departmentID);
         if(us!=null){
             return us;
         }
         return null;
     }
     public Note getNote(String noteID){
         Note us = (Note) emf.createEntityManager().find(Note.class, noteID);
         if(us!=null){
             return us;
         }
         return null;
     }
     public Professor getProfessor(String professorID){
         Professor us = (Professor) emf.createEntityManager().find(Professor.class, professorID);
         if(us!=null){
             return us;
         }
         return null;
     }
     public Questionbank getQuestionbank(String username){
         Questionbank us = (Questionbank) emf.createEntityManager().find(Questionbank.class, username);
         if(us!=null){
             return us;
         }
         return null;
     }
     public School getSchool(String schoolID){
         School us = (School) emf.createEntityManager().find(School.class, schoolID);
         if(us!=null){
             return us;
         }
         return null;
     }
     public Student getStudent(String userID){
         Student us = (Student) emf.createEntityManager().find(Student.class, userID);
         if(us!=null){
             return us;
         }
         return null;
     }
     public Test getTest(String testID){
         Test us = (Test) emf.createEntityManager().find(Test.class, testID);
         if(us!=null){
             return us;
         }
         return null;
     }
     public Transcript getTranscript(String username){
         Transcript us = (Transcript) emf.createEntityManager().find(Transcript.class, username);
         if(us!=null){
             return us;
         }
         return null;
     }
     public User getUser(String username){
         User us = (User) emf.createEntityManager().find(User.class, username);
         if(us!=null){
             return us;
         }
         return null;
     }
}