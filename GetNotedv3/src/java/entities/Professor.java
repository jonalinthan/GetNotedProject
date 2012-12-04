/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jonathan
 */
@Entity
@Table(name = "professor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Professor.findAll", query = "SELECT p FROM Professor p"),
    @NamedQuery(name = "Professor.findByProfessorID", query = "SELECT p FROM Professor p WHERE p.professorID = :professorID")})
public class Professor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "professorID")
    private String professorID;
    @JoinColumn(name = "department", referencedColumnName = "departmentID")
    @ManyToOne(optional = false)
    private Department department;

    public Professor() {
    }

    public Professor(String professorID) {
        this.professorID = professorID;
    }

    public String getProfessorID() {
        return professorID;
    }

    public void setProfessorID(String professorID) {
        this.professorID = professorID;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (professorID != null ? professorID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Professor)) {
            return false;
        }
        Professor other = (Professor) object;
        if ((this.professorID == null && other.professorID != null) || (this.professorID != null && !this.professorID.equals(other.professorID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Professor[ professorID=" + professorID + " ]";
    }
    
}
