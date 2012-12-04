/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Jonathan
 */
@Embeddable
public class TranscriptPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "courseCode")
    private String courseCode;

    public TranscriptPK() {
    }

    public TranscriptPK(String username, String courseCode) {
        this.username = username;
        this.courseCode = courseCode;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (username != null ? username.hashCode() : 0);
        hash += (courseCode != null ? courseCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TranscriptPK)) {
            return false;
        }
        TranscriptPK other = (TranscriptPK) object;
        if ((this.username == null && other.username != null) || (this.username != null && !this.username.equals(other.username))) {
            return false;
        }
        if ((this.courseCode == null && other.courseCode != null) || (this.courseCode != null && !this.courseCode.equals(other.courseCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TranscriptPK[ username=" + username + ", courseCode=" + courseCode + " ]";
    }
    
}
