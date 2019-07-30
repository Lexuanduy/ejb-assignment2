/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import dao.UserDao;
import javax.ejb.Stateless;

/**
 *
 * @author duy
 */
@Stateless
public class UserSessionBean implements UserSessionBeanLocal {

    @Override
    public boolean login(String username, String password) {
        UserDao u = new UserDao();
        return u.checkLogin(username, password);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
}
