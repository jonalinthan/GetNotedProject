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
@Table(name = "school")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "School.findAll", query = "SELECT s FROM School s"),
    @NamedQuery(name = "School.findBySchoolID", query = "SELECT s FROM School s WHERE s.schoolID = :schoolID"),
    @NamedQuery(name = "School.findByNameOfSchool", query = "SELECT s FROM School s WHERE s.nameOfSchool = :nameOfSchool"),
    @NamedQuery(name = "School.findBySchoolRegion", query = "SELECT s FROM School s WHERE s.schoolRegion = :schoolRegion"),
    @NamedQuery(name = "School.findByPublicOrPrivate", query = "SELECT s FROM School s WHERE s.publicOrPrivate = :publicOrPrivate")})
public class School implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "schoolID")
    private String schoolID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nameOfSchool")
    private String nameOfSchool;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "schoolRegion")
    private String schoolRegion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "publicOrPrivate")
    private int publicOrPrivate;

    public School() {
    }

    public School(String schoolID) {
        this.schoolID = schoolID;
    }

    public School(String schoolID, String nameOfSchool, String schoolRegion, int publicOrPrivate) {
        this.schoolID = schoolID;
        this.nameOfSchool = nameOfSchool;
        this.schoolRegion = schoolRegion;
        this.publicOrPrivate = publicOrPrivate;
    }

    public String getSchoolID() {
        return schoolID;
    }

    public void setSchoolID(String schoolID) {
        this.schoolID = schoolID;
    }

    public String getNameOfSchool() {
        return nameOfSchool;
    }

    public void setNameOfSchool(String nameOfSchool) {
        this.nameOfSchool = nameOfSchool;
    }

    public String getSchoolRegion() {
        return schoolRegion;
    }

    public void setSchoolRegion(String schoolRegion) {
        this.schoolRegion = schoolRegion;
    }

    public int getPublicOrPrivate() {
        return publicOrPrivate;
    }

    public void setPublicOrPrivate(int publicOrPrivate) {
        this.publicOrPrivate = publicOrPrivate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (schoolID != null ? schoolID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof School)) {
            return false;
        }
        School other = (School) object;
        if ((this.schoolID == null && other.schoolID != null) || (this.schoolID != null && !this.schoolID.equals(other.schoolID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.School[ schoolID=" + schoolID + " ]";
    }
    
}
