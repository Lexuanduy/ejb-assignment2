/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import entity.User;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import util.NewHibernateUtil;

/**
 *
 */
public class UserDao {
    public boolean checkLogin(String username, String password) {
        Session session = NewHibernateUtil.getSessionAndBeginTransaction();
        try {
            String sql = "SELECT u from User u where u.username=:username and u.password=:password";
            Query query = session.createQuery(sql);
            query.setParameter("username", username);
            query.setParameter("password", password);
            List<User> list = query.list();
            if (list.size() == 1 ) {
                session.close();
                return true;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                NewHibernateUtil.commitCurrentSessions();
            } catch (Exception ex) {
                Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    NewHibernateUtil.closeCurrentSessions();
                } catch (Exception ex) {
                    Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return false;
    }
}
