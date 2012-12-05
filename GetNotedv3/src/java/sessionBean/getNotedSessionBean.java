/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBean;

import entities.*;
import java.util.Vector;
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
    
    public Professor lookUpProfessor(String username){
        String query = "SELECT P.professorID FROM User U, Professor P WHERE U.username='" + username + "'";
        List<String> temp = emf.createEntityManager().createNativeQuery(query).getResultList();
            if (temp.size() <= 0)
                return null;
        Professor prof = (Professor) emf.createEntityManager().find(Professor.class, temp.get(0));
        return prof;
    }
    
    public Student lookUpStudent(String username){
        String query = "SELECT S.studentID FROM User U, Student S WHERE U.username='" + username + "'";
        List<String> temp = emf.createEntityManager().createNativeQuery(query).getResultList();
            if (temp.size() <= 0)
                return null;
        Student stud = (Student) emf.createEntityManager().find(Student.class, temp.get(0));
        return stud;
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
	public Vector<String> getUsersBuddies(String username){
		String query = "SELECT userID FROM Buddies WHERE friendsWith='" + username + "'";
		List<String> temp = emf.createEntityManager().createNativeQuery(query).getResultList();
		Vector<String> ntemp = new Vector<String>();
		for(int i=0; i<temp.size(); i++){
            String query2= "SELECT username FROM user WHERE userID=" + temp.get(i);
            ntemp.add((String)emf.createEntityManager().createNativeQuery(query2).getSingleResult());
		}
		return ntemp;
		
	}
	public List<Note> sort(String username){
        String query2 = "SELECT userID FROM user WHERE username='"+username+"'";
		
        String query="SELECT N.user, N.netvotes FROM note N, user U WHERE U.userID= N.user AND U.userID= "+query2+" ORDER BY N.netVote DESC";
        List<Note> result= emf.createEntityManager().createNativeQuery(query).getResultList();
        return result;
    }
    public List<Note> sortId(String username){
        String query2 = "SELECT userID FROM user WHERE username='"+username+"'";
		
        String query="SELECT N.user, N.netvotes FROM note N, user U WHERE U.userID= N.user AND U.userID="+query2+" ORDER BY N.user DESC";
        List<Note> result= emf.createEntityManager().createNativeQuery(query).getResultList();
        return result;
    }
    public List<String> getSchoolsWithNoBuddies(String username){
        String query2 = "SELECT userID FROM user WHERE username='"+username+"'";
        String query = "SELECT s.nameOfSchool FROM School s WHERE s.nameOfSchool NOT IN(SELECT DISTINCT s.nameOfSchool FROM buddies b, school s, user u WHERE 2= b.friendsWith AND b.friendsWith ="+query2+ "AND u.school = s.nameOfSchool)";
        List<String> result = emf.createEntityManager().createNativeQuery(query).getResultList();
        return result;
    }
	
    public List<String> listQB(Professor professor){
        List<String> temp = null;
        
        if(professor != null){
            String query = "SELECT Distinct q.question FROM questionbank q, User u, Professor p WHERE u.userID= '" + professor.getProfessorID() + "' AND q.questionOwner = u.username";
            temp = emf.createEntityManager().createNativeQuery(query).getResultList();
        }
        return temp;
    }
	
    public List<String> getQBAnswer(Professor professor, String question){
        List<String> temp = null;
        
        if(professor != null){
			String query = "SELECT q.correctAnswer FROM questionbank q, User u, Professor p WHERE u.userID= '" + professor.getProfessorID() + "' AND q.questionOwner = u.username AND q.question = '" + question + "'";
			temp = emf.createEntityManager().createNativeQuery(query).getResultList();
        }
        return temp;
    }
	public List<Note> getUserNote(String username){
        String query = "SELECT * FROM note WHERE noteID='"+username+"'";
        List<Note> searchResults = null;
		
        searchResults = emf.createEntityManager().createNativeQuery(query).getResultList();
        
        return searchResults;
    }
    public List<String> getProfCourses(String profName){
		Vector<String> vs = new Vector<String>();
		String profName2 = "SELECT userID FROM user WHERE userID= '"+profName+"'";
		String actualName = (String)emf.createEntityManager().createNativeQuery(profName2).getSingleResult();
		String query = "SELECT c.courseName FROM course c WHERE c.professor = "+actualName;
		List<String> temp = emf.createEntityManager().createNativeQuery(query).getResultList();
		return temp;
    } 
    
    public String getNumCourses(String userID){
        String query = "SELECT s.userID, Count(t.courseCode) FROM transcript t, student s WHERE t.username = s.userID GROUP BY s.userID ASC";
        String result = (String)emf.createEntityManager().createNativeQuery(query).getSingleResult();
        return result;
    }
    public List<String> getCoursesTaken(String userID){
        String query = "SELECT T.courseCode, S.userID FROM transcript T, student S WHERE"+ userID+"= T.username";
        List<String> result= (List<String>)emf.createEntityManager().createNativeQuery(query).getResultList();
        return result;
    }
    public List<String> getBuddyCourses(String userID){
        String query = "SELECT B.userID, T.courseCode FROM buddies B, transcript T, student S WHERE B.friendsWith= S.userID AND T.username= B.userID";
        List<String> result = (List<String>)emf.createEntityManager().createNativeQuery(query).getResultList();
        return result;
    }
    public List<String> getCurrentCourses(String userID){
        String query = "";
        List<String> result = (List<String>)emf.createEntityManager().createNativeQuery(query).getResultList();
        return result;
    }
    public List<Note> userQuery(String keyword, String criteria){
        String query = "";
        String searchable="";
        if(criteria.equals("user")){
            query = "SELECT userID FROM user WHERE userID= '"+keyword+"'";
            searchable= (String)emf.createEntityManager().createNativeQuery(query).getSingleResult();
        }
        else{
            searchable = keyword;
        }
		List<Note> results=(List<Note>)searchNote(searchable, criteria);
		return results;
    }
	
    private List<Note> searchNote(String keyword, String criteria){
		String query="";
		if(criteria.equals("user")){
			query = "SELECT * FROM note WHERE user='"+keyword+"'";
		}
		else{
			query = "SELECT * FROM note WHERE nameOfNote='"+keyword+"'";
		}
		List<Note> searchable = (List<Note>)emf.createEntityManager().createNativeQuery(query).getResultList();
		return searchable;
    }
	public ArrayList<Object> departmentAverages() throws SQLException{
        ConnectionManager cm = ConnectionManager.getManager();
        Connection con= cm.getConnection();
        Statement stmt = con.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE,
											 ResultSet.CONCUR_UPDATABLE);   
        String query = "SELECT D.departmentName, AVG(T.averageScore) FROM department D, test T, professor P WHERE P.department = D.departmentID AND T.testOwner=P.professorID GROUP BY department DESC";
        ResultSet result =stmt.executeQuery(query);
        ArrayList<Object> list = new ArrayList<Object>();
        int i=0;
        for(i=0; i<list.size(); i++){
            list.add(result.getArray(i));
        }
        return list;
    }
    public List<Object> avgNotes() throws SQLException{
        ConnectionManager cm = ConnectionManager.getManager();
        Connection con= cm.getConnection();
        Statement stmt = con.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE,
											 ResultSet.CONCUR_UPDATABLE);   
        String query="SELECT CourseCode, AVG(A.Average) FROM AvgNotes A GROUP BY(CourseCode)";
        ResultSet result =stmt.executeQuery(query);
        ArrayList<Object> list = new ArrayList<Object>();
        int i=0;
        for(i=0; i<list.size(); i++){
            list.add(result.getArray(i));
        }
        return list;
    }
}