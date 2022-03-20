/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.student.servlet;

import co.edu.unipiloto.student.Student;
import co.edu.unipiloto.student.session.StudentFacadeLocal;
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
public class StudentServlet extends HttpServlet {

    @EJB
    private StudentFacadeLocal studentFacade;

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

        Integer stID = new Integer(0);
        Integer yearLVL = new Integer(0);
        String id = request.getParameter("studentId");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String yearLevel = request.getParameter("yearLevel");

        if (id != null && !id.equals("")) {
            stID = Integer.parseInt(id);
        }
        if (yearLevel != null && !yearLevel.equals("")) {
            yearLVL = Integer.parseInt(yearLevel);
        }

        Student st = new Student();
        String accion = request.getParameter("action");

        if (accion.equals("Add")) {

            st.setFirstname(firstName);
            st.setLastname(lastName);
            st.setStudentid(stID);
            st.setYearlevel(yearLVL);
            studentFacade.create(st);
        }

        request.setAttribute("student", st);
        request.setAttribute("allStudents", studentFacade.findAll());
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
