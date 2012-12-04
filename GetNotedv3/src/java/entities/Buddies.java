/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jonathan
 */
@Entity
@Table(name = "buddies")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Buddies.findAll", query = "SELECT b FROM Buddies b"),
    @NamedQuery(name = "Buddies.findByFriendsWith", query = "SELECT b FROM Buddies b WHERE b.buddiesPK.friendsWith = :friendsWith"),
    @NamedQuery(name = "Buddies.findByUserID", query = "SELECT b FROM Buddies b WHERE b.buddiesPK.userID = :userID")})
public class Buddies implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected BuddiesPK buddiesPK;

    public Buddies() {
    }

    public Buddies(BuddiesPK buddiesPK) {
        this.buddiesPK = buddiesPK;
    }

    public Buddies(String friendsWith, String userID) {
        this.buddiesPK = new BuddiesPK(friendsWith, userID);
    }

    public BuddiesPK getBuddiesPK() {
        return buddiesPK;
    }

    public void setBuddiesPK(BuddiesPK buddiesPK) {
        this.buddiesPK = buddiesPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (buddiesPK != null ? buddiesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Buddies)) {
            return false;
        }
        Buddies other = (Buddies) object;
        if ((this.buddiesPK == null && other.buddiesPK != null) || (this.buddiesPK != null && !this.buddiesPK.equals(other.buddiesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Buddies[ buddiesPK=" + buddiesPK + " ]";
    }
    
}
