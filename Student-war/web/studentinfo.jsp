<%-- 
    Document   : studentinfo
    Created on : 19/03/2022, 03:20:26 AM
    Author     : jupbc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student Information</title>
    </head>
    <body>
        <h1>Student Information</h1>
        <form action="./StudentServlet" method="POST">
            <table>
                <tr>
                    <td>ID del estudiante</td>
                    <td><input type="text" name="studentId" value="${student.studentid}" /></td>
                </tr>
                <tr>
                    <td>Nombre</td>
                    <td><input type="text" name="firstName" value="${student.firstname}" /></td>
                </tr>
                <tr>
                    <td>Apellido</td>
                    <td><input type="text" name="lastName" value="${student.lastname}" /></td>
                </tr>
                <tr>
                    <td>Semestre</td>
                    <td><input type="text" name="yearLevel" value="${student.yearlevel}" /></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" name="action" value="Add" />
                        <input type="submit" name="action" value="Edit" />
                        <input type="submit" name="action" value="Delete" />
                        <input type="submit" name="action" value="Search" />
                    </td>
                </tr>
            </table>
        </form>
        <br>
        <table border="1">
            <th>ID estudiante</th>
            <th>Nombre</th>
            <th>Apellido</th>
            <th>Semestre</th>
                <c:forEach items="${allStudents}" var="stud">
                <tr>
                    <td>${stud.studentid}</td>
                    <td>${stud.firstname}</td>
                    <td>${stud.lastname}</td>
                    <td>${stud.yearlevel}</td>
                </tr>
            </c:forEach> 
        </table>
        <h1>Course Information</h1>
        <form action="./CourseServlet" method="POST">
            <table>
                <tr>
                    <td>ID del curso</td>
                    <td><input type="text" name="courseId" value="${course.courseid}" /></td>
                </tr>
                <tr>
                    <td>Nombre</td>
                    <td><input type="text" name="courseName" value="${course.coursename}" /></td>
                </tr>
                <tr>
                    <td>Creditos</td>
                    <td><input type="text" name="courseCredits" value="${course.coursecredits}" /></td>
                </tr>
                <tr>
                    <td>Semestre</td>
                    <td><input type="text" name="yearLevel" value="${course.yearlevel}" /></td>
                </tr>
                <tr>
                    <td>Numero de estudiantes</td>
                    <td><input type="text" name="studentsNumber" value="${course.studentsnumber}" /></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" name="action" value="Add" />
                        <input type="submit" name="action" value="Edit" />
                        <input type="submit" name="action" value="Delete" />
                        <input type="submit" name="action" value="Search" />
                    </td>
                </tr>
            </table>
        </form>
        <table border="1">
            <th>ID del curso</th>
            <th>Nombre</th>
            <th>Creditos</th>
            <th>Semestre</th>
            <th>Numero de estudiantes</th>
                <c:forEach items="${allCourses}" var="cour">
                <tr>
                    <td>${cour.courseid}</td>
                    <td>${cour.coursename}</td>
                    <td>${cour.coursecredits}</td>
                    <td>${cour.yearlevel}</td>
                    <td>${cour.studentsnumber}</td>
                </tr>
            </c:forEach> 
        </table>
                
        <h1>Course Grades</h1>
        <form action="./GradeServlet" method="POST">
            <table>
                <tr>
                    <td>ID del curso</td>
                    <td><input type="text" name="courseId" value="${grade.studentCoursePK.courseid}" /></td>
                </tr>
                <tr>
                    <td>ID del estudiante</td>
                    <td><input type="text" name="studentId" value="${grade.studentCoursePK.studentid}" /></td>
                </tr>
                <tr>
                    <td>Nota</td>
                    <td><input type="text" name="grade" value="${grade.grade}" /></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" name="action" value="Add" />
                        <input type="submit" name="action" value="Edit" />
                        <input type="submit" name="action" value="Delete" />
                        <input type="submit" name="action" value="Search" />
                    </td>
                </tr>
            </table>
        </form>
        <table border="1">
            <th>ID del curso</th>
            <th>ID del estudiante</th>
            <th>Nota</th>
                <c:forEach items="${allGrades}" var="grad">
                <tr>
                    <td>${grad.studentCoursePK.courseid}</td>
                    <td>${grad.studentCoursePK.studentid}</td>
                    <td>${grad.grade}</td>
                </tr>
            </c:forEach> 
        </table>        
    </body>
</html>