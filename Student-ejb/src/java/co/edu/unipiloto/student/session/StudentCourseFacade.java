/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.student.session;

import co.edu.unipiloto.student.StudentCourse;
import co.edu.unipiloto.student.StudentCoursePK;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author jupbc
 */
@Stateless
public class StudentCourseFacade extends AbstractFacade<StudentCourse> implements StudentCourseFacadeLocal {

    @PersistenceContext(unitName = "StudentPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public StudentCourseFacade() {
        super(StudentCourse.class);
    }

    @Override
    public boolean insertCourseStudent(int courseId, int studentId, int grade) {
        
        StudentCoursePK pk = new StudentCoursePK(courseId, studentId);
        if(queryStudentCourse(pk)!=null){
            
            return false;
        }else{
            
            StudentCourse sc = new StudentCourse(pk, grade);
            em.persist(sc);
            return true;
        }
    }

    @Override
    public StudentCourse queryStudentCourse(StudentCoursePK pk) {
        return em.find(StudentCourse.class, pk);
    }
    
}
