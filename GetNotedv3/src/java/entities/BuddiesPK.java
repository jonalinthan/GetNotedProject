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
public class BuddiesPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "friendsWith")
    private String friendsWith;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "userID")
    private String userID;

    public BuddiesPK() {
    }

    public BuddiesPK(String friendsWith, String userID) {
        this.friendsWith = friendsWith;
        this.userID = userID;
    }

    public String getFriendsWith() {
        return friendsWith;
    }

    public void setFriendsWith(String friendsWith) {
        this.friendsWith = friendsWith;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (friendsWith != null ? friendsWith.hashCode() : 0);
        hash += (userID != null ? userID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BuddiesPK)) {
            return false;
        }
        BuddiesPK other = (BuddiesPK) object;
        if ((this.friendsWith == null && other.friendsWith != null) || (this.friendsWith != null && !this.friendsWith.equals(other.friendsWith))) {
            return false;
        }
        if ((this.userID == null && other.userID != null) || (this.userID != null && !this.userID.equals(other.userID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.BuddiesPK[ friendsWith=" + friendsWith + ", userID=" + userID + " ]";
    }
    
}
