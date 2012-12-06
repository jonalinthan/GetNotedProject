<%-- 
    Document   : professorPage
    Created on : Dec 4, 2012, 3:27:19 AM
    Author     : aaronmeltzer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student Page</title>
    </head>
    <body>
        <h1>Student Page</h1>
        <form method="post" name="studentsettings" action="StudentSettingsServlet" >
                    <input type="submit" value="Settings" />
        </form>
        
        <form method="post" name="studentavgnotes" action="AvgNoteServlet" >
                    <input type="submit" value="See Note averages by class" />
        </form>
        <form method="post" name="buddycourses" action="BuddyCoursesServlet" >
                    <input type="submit" value="See all your buddies' courses" />
        </form>
        <form method="post" name="curCourse" action="CurCoursesServlet" >
                    <input type="submit" value="Check the courses you are taking this semester" />
        </form>
        <form method="post" name="getbuddies" action="GetBuddiesServlet" >
                    <input type="submit" value="See all your buddies" />
        </form>
        <form method="post" name="studentgetnotes" action="GetNoteServlet" >
                    <input type="submit" value="See all your notes" />
        </form>
        <form method="post" name="studentCourses" action="GetStudentCoursesServlet" >
                    <input type="submit" value="See info about all your courses" />
        </form>
        <form method="post" name="prof courses" action="ListNotes" >
                    <input type="submit" value="See all courses taught by the Professor" />
        </form>
        <form method="post" name="lon" action="SchoolNoBuddiesServlet" >
                    <input type="password" name="profName" /><br />
                    <input type="submit" value="See which schools you do not have a buddy at yet" />
        </form>
        
    </body>
</html>
