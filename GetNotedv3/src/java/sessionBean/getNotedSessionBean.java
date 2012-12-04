/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBean;

import entities.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.*;
import javax.sql.DataSource;

/**
 *
 * @author Jonathan
 */
@Stateless
@LocalBean
public class getNotedSessionBean {

    @PersistenceUnit
    EntityManagerFactory emf;
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    public User checkUser(String username, String password) {
        String query = "SELECT userID FROM User WHERE username='" + username + "'";
        List<String> temp = emf.createEntityManager().createNativeQuery(query).getResultList();
            if (temp.size() <= 0)
                return null;
        User user = (User) emf.createEntityManager().find(User.class, temp.get(0));
        if (user != null) { 
            if (user.getPassword().equals(password)) {
                return user;
            }
            else {
                return null;
            }
        }
        else {
            return null;
        }
    }
}
