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
public class NotePK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "noteID")
    private String noteID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "user")
    private String user;

    public NotePK() {
    }

    public NotePK(String noteID, String user) {
        this.noteID = noteID;
        this.user = user;
    }

    public String getNoteID() {
        return noteID;
    }

    public void setNoteID(String noteID) {
        this.noteID = noteID;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (noteID != null ? noteID.hashCode() : 0);
        hash += (user != null ? user.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NotePK)) {
            return false;
        }
        NotePK other = (NotePK) object;
        if ((this.noteID == null && other.noteID != null) || (this.noteID != null && !this.noteID.equals(other.noteID))) {
            return false;
        }
        if ((this.user == null && other.user != null) || (this.user != null && !this.user.equals(other.user))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.NotePK[ noteID=" + noteID + ", user=" + user + " ]";
    }
    
}
