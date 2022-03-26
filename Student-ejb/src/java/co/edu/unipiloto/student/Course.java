/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.student;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jupbc
 */
@Entity
@Table(name = "COURSE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Course.findAll", query = "SELECT c FROM Course c"),
    @NamedQuery(name = "Course.findByCourseid", query = "SELECT c FROM Course c WHERE c.courseid = :courseid"),
    @NamedQuery(name = "Course.findByCoursename", query = "SELECT c FROM Course c WHERE c.coursename = :coursename"),
    @NamedQuery(name = "Course.findByCoursecredits", query = "SELECT c FROM Course c WHERE c.coursecredits = :coursecredits"),
    @NamedQuery(name = "Course.findByYearlevel", query = "SELECT c FROM Course c WHERE c.yearlevel = :yearlevel"),
    @NamedQuery(name = "Course.findByStudentsnumber", query = "SELECT c FROM Course c WHERE c.studentsnumber = :studentsnumber")})
public class Course implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "COURSEID")
    private Integer courseid;
    @Size(max = 50)
    @Column(name = "COURSENAME")
    private String coursename;
    @Column(name = "COURSECREDITS")
    private Integer coursecredits;
    @Column(name = "YEARLEVEL")
    private Integer yearlevel;
    @Column(name = "STUDENTSNUMBER")
    private Integer studentsnumber;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "course")
    private Collection<StudentCourse> studentCourseCollection;

    public Course() {
    }

    public Course(Integer courseid) {
        this.courseid = courseid;
    }

    public Integer getCourseid() {
        return courseid;
    }

    public void setCourseid(Integer courseid) {
        this.courseid = courseid;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public Integer getCoursecredits() {
        return coursecredits;
    }

    public void setCoursecredits(Integer coursecredits) {
        this.coursecredits = coursecredits;
    }

    public Integer getYearlevel() {
        return yearlevel;
    }

    public void setYearlevel(Integer yearlevel) {
        this.yearlevel = yearlevel;
    }

    public Integer getStudentsnumber() {
        return studentsnumber;
    }

    public void setStudentsnumber(Integer studentsnumber) {
        this.studentsnumber = studentsnumber;
    }

    @XmlTransient
    public Collection<StudentCourse> getStudentCourseCollection() {
        return studentCourseCollection;
    }

    public void setStudentCourseCollection(Collection<StudentCourse> studentCourseCollection) {
        this.studentCourseCollection = studentCourseCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (courseid != null ? courseid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Course)) {
            return false;
        }
        Course other = (Course) object;
        if ((this.courseid == null && other.courseid != null) || (this.courseid != null && !this.courseid.equals(other.courseid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.unipiloto.student.Course[ courseid=" + courseid + " ]";
    }
    
}
