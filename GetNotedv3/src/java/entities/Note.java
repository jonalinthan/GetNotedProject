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
@Table(name = "note")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Note.findAll", query = "SELECT n FROM Note n"),
    @NamedQuery(name = "Note.findByNoteID", query = "SELECT n FROM Note n WHERE n.notePK.noteID = :noteID"),
    @NamedQuery(name = "Note.findByNameOfNote", query = "SELECT n FROM Note n WHERE n.nameOfNote = :nameOfNote"),
    @NamedQuery(name = "Note.findByUser", query = "SELECT n FROM Note n WHERE n.notePK.user = :user"),
    @NamedQuery(name = "Note.findByTopic", query = "SELECT n FROM Note n WHERE n.topic = :topic"),
    @NamedQuery(name = "Note.findByClass1", query = "SELECT n FROM Note n WHERE n.class1 = :class1"),
    @NamedQuery(name = "Note.findByContent", query = "SELECT n FROM Note n WHERE n.content = :content"),
    @NamedQuery(name = "Note.findByNetVotes", query = "SELECT n FROM Note n WHERE n.netVotes = :netVotes"),
    @NamedQuery(name = "Note.findByRating", query = "SELECT n FROM Note n WHERE n.rating = :rating")})
public class Note implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected NotePK notePK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nameOfNote")
    private String nameOfNote;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "topic")
    private String topic;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "class")
    private String class1;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "content")
    private String content;
    @Basic(optional = false)
    @NotNull
    @Column(name = "netVotes")
    private int netVotes;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "rating")
    private String rating;
    @JoinColumn(name = "user", referencedColumnName = "userID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private User user1;

    public Note() {
    }

    public Note(NotePK notePK) {
        this.notePK = notePK;
    }

    public Note(NotePK notePK, String nameOfNote, String topic, String class1, String content, int netVotes, String rating) {
        this.notePK = notePK;
        this.nameOfNote = nameOfNote;
        this.topic = topic;
        this.class1 = class1;
        this.content = content;
        this.netVotes = netVotes;
        this.rating = rating;
    }

    public Note(String noteID, String user) {
        this.notePK = new NotePK(noteID, user);
    }

    public NotePK getNotePK() {
        return notePK;
    }

    public void setNotePK(NotePK notePK) {
        this.notePK = notePK;
    }

    public String getNameOfNote() {
        return nameOfNote;
    }

    public void setNameOfNote(String nameOfNote) {
        this.nameOfNote = nameOfNote;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getClass1() {
        return class1;
    }

    public void setClass1(String class1) {
        this.class1 = class1;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getNetVotes() {
        return netVotes;
    }

    public void setNetVotes(int netVotes) {
        this.netVotes = netVotes;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public User getUser1() {
        return user1;
    }

    public void setUser1(User user1) {
        this.user1 = user1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (notePK != null ? notePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Note)) {
            return false;
        }
        Note other = (Note) object;
        if ((this.notePK == null && other.notePK != null) || (this.notePK != null && !this.notePK.equals(other.notePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Note[ notePK=" + notePK + " ]";
    }
    
}
