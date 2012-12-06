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
@Table(name = "student")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Student.findAll", query = "SELECT s FROM Student s"),
    @NamedQuery(name = "Student.findByUserID", query = "SELECT s FROM Student s WHERE s.userID = :userID"),
    @NamedQuery(name = "Student.findByMajor", query = "SELECT s FROM Student s WHERE s.major = :major"),
    @NamedQuery(name = "Student.findByYearOfGraduation", query = "SELECT s FROM Student s WHERE s.yearOfGraduation = :yearOfGraduation")})
public class Student implements Serializable {
    @JoinColumn(name = "userID", referencedColumnName = "userID")
    @OneToOne(optional = false)
    private User user;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "userID")
    private String userID;
    @Size(max = 45)
    @Column(name = "major")
    private String major;
    @Basic(optional = false)
    @NotNull
    @Column(name = "yearOfGraduation")
    private int yearOfGraduation;

    public Student() {
    }

    public Student(String userID) {
        this.userID = userID;
    }

    public Student(String userID, int yearOfGraduation) {
        this.userID = userID;
        this.yearOfGraduation = yearOfGraduation;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public int getYearOfGraduation() {
        return yearOfGraduation;
    }

    public void setYearOfGraduation(int yearOfGraduation) {
        this.yearOfGraduation = yearOfGraduation;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userID != null ? userID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Student)) {
            return false;
        }
        Student other = (Student) object;
        if ((this.userID == null && other.userID != null) || (this.userID != null && !this.userID.equals(other.userID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Student[ userID=" + userID + " ]";
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
}
