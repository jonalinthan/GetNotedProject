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
@Table(name = "transcript")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Transcript.findAll", query = "SELECT t FROM Transcript t"),
    @NamedQuery(name = "Transcript.findByIsCurrentlyTaking", query = "SELECT t FROM Transcript t WHERE t.isCurrentlyTaking = :isCurrentlyTaking"),
    @NamedQuery(name = "Transcript.findByUsername", query = "SELECT t FROM Transcript t WHERE t.transcriptPK.username = :username"),
    @NamedQuery(name = "Transcript.findByCourseCode", query = "SELECT t FROM Transcript t WHERE t.transcriptPK.courseCode = :courseCode"),
    @NamedQuery(name = "Transcript.findBySemester", query = "SELECT t FROM Transcript t WHERE t.semester = :semester")})
public class Transcript implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TranscriptPK transcriptPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isCurrentlyTaking")
    private int isCurrentlyTaking;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "semester")
    private String semester;
    @JoinColumn(name = "username", referencedColumnName = "userID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private User user;

    public Transcript() {
    }

    public Transcript(TranscriptPK transcriptPK) {
        this.transcriptPK = transcriptPK;
    }

    public Transcript(TranscriptPK transcriptPK, int isCurrentlyTaking, String semester) {
        this.transcriptPK = transcriptPK;
        this.isCurrentlyTaking = isCurrentlyTaking;
        this.semester = semester;
    }

    public Transcript(String username, String courseCode) {
        this.transcriptPK = new TranscriptPK(username, courseCode);
    }

    public TranscriptPK getTranscriptPK() {
        return transcriptPK;
    }

    public void setTranscriptPK(TranscriptPK transcriptPK) {
        this.transcriptPK = transcriptPK;
    }

    public int getIsCurrentlyTaking() {
        return isCurrentlyTaking;
    }

    public void setIsCurrentlyTaking(int isCurrentlyTaking) {
        this.isCurrentlyTaking = isCurrentlyTaking;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (transcriptPK != null ? transcriptPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Transcript)) {
            return false;
        }
        Transcript other = (Transcript) object;
        if ((this.transcriptPK == null && other.transcriptPK != null) || (this.transcriptPK != null && !this.transcriptPK.equals(other.transcriptPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Transcript[ transcriptPK=" + transcriptPK + " ]";
    }
    
}
