/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.student.servlet;

import co.edu.unipiloto.student.Course;
import co.edu.unipiloto.student.session.CourseFacadeLocal;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jupbc
 */
public class CourseServlet extends HttpServlet {

    @EJB
    private CourseFacadeLocal courseFacade;

    
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
        
        Integer crID = new Integer(0);
        Integer crCRED = new Integer(0);
        Integer yearLVL = new Integer(0);
        Integer stNUMB = new Integer(0);
        String id = request.getParameter("courseId");
        String courseName = request.getParameter("courseName");
        String courseCredits = request.getParameter("courseCredits");
        String yearLevel = request.getParameter("yearLevel");
        String studentsNumber = request.getParameter("studentsNumber");

        if (id != null && !id.equals("")) {
            crID = Integer.parseInt(id);
        }
        if (courseCredits != null && !courseCredits.equals("")) {
            crCRED = Integer.parseInt(courseCredits);
        }
        if (yearLevel != null && !yearLevel.equals("")) {
            yearLVL = Integer.parseInt(yearLevel);
        }
        if (studentsNumber != null && !studentsNumber.equals("")) {
            stNUMB = Integer.parseInt(studentsNumber);
        }


        Course cr = new Course();
        String accion = request.getParameter("action");
        cr.setCoursename(courseName);
        cr.setCoursecredits(crCRED);
        cr.setCourseid(crID);
        cr.setYearlevel(yearLVL);
        cr.setStudentsnumber(stNUMB);

        if (accion.equals("Add")) {

            courseFacade.create(cr);
        } else if (accion.equals("Edit")) {

            courseFacade.edit(cr);
        } else if (accion.equals("Delete")) {

            courseFacade.remove(cr);
        } else if (accion.equals("Search")) {

            cr = courseFacade.find(crID);
        }

        request.setAttribute("course", cr);
        request.setAttribute("allCourses", courseFacade.findAll());
        request.getRequestDispatcher("studentinfo.jsp").forward(request, response);
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

}
