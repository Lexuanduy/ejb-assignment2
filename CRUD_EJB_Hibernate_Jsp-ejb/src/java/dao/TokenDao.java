/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import entity.Token;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.Query;
import org.hibernate.Session;
import util.NewHibernateUtil;

/**
 *
 */
public class TokenDao {

    public boolean insertToken(String tokenStringInsert, int userIdInsert) {
        try {
            Session session = NewHibernateUtil.getSessionAndBeginTransaction();
            Token tk = new Token();
            tk.setUserId(userIdInsert);
            tk.setTokenString(tokenStringInsert);
            session.persist(tk); //Insert
            NewHibernateUtil.commitCurrentSessions();
            return true;
        } catch (Exception ex) {
            Logger.getLogger(TokenDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                NewHibernateUtil.commitCurrentSessions();
            } catch (Exception ex) {
                Logger.getLogger(TokenDao.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    NewHibernateUtil.closeCurrentSessions();
                } catch (Exception ex) {
                    Logger.getLogger(TokenDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return false;
    }

    public boolean updateToken(String tokenString, int userId) {
        try {
            Session session = NewHibernateUtil.getSessionAndBeginTransaction();
            String hql = "UPDATE Token SET tokenString = :tokenString WHERE userId = :userId";
            Query query = session.createQuery(hql);
            query.setParameter("userId", userId);
            query.setParameter("tokenString", tokenString);

            query.executeUpdate(); //Update
            NewHibernateUtil.commitCurrentSessions();
            return true;
        } catch (Exception ex) {
            NewHibernateUtil.rollBackCurrentSessions();
        } finally {
            try {
                NewHibernateUtil.commitCurrentSessions();
            } catch (Exception ex) {
                Logger.getLogger(TokenDao.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    NewHibernateUtil.closeCurrentSessions();
                } catch (Exception ex) {
                    Logger.getLogger(TokenDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return false;
    }

    public List<Token> getAll() {
        Session session = NewHibernateUtil.getSessionAndBeginTransaction();
        try {
            String hql = "SELECT t FROM Token t";
            Query query = session.createQuery(hql);
            
            return query.list();
        } catch (Exception e) {
            NewHibernateUtil.rollBackCurrentSessions();
        } finally {
            try {
                NewHibernateUtil.commitCurrentSessions();
            } catch (Exception ex) {
                Logger.getLogger(TokenDao.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    NewHibernateUtil.closeCurrentSessions();
                } catch (Exception ex) {
                    Logger.getLogger(TokenDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return null;
    }

    public boolean deleteToken(int userId) {
        try {
            Session session = NewHibernateUtil.getSessionAndBeginTransaction();
            String hql = "DELETE FROM Token WHERE userId = :userId";
            Query query = session.createQuery(hql);
            query.setParameter("userId", userId);

            query.executeUpdate(); //Delete
            NewHibernateUtil.commitCurrentSessions();
            return true;
        } catch (Exception ex) {
            NewHibernateUtil.rollBackCurrentSessions();
        } finally {
            try {
                NewHibernateUtil.commitCurrentSessions();
            } catch (Exception ex) {
                Logger.getLogger(TokenDao.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    NewHibernateUtil.closeCurrentSessions();
                } catch (Exception ex) {
                    Logger.getLogger(TokenDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return false;
    }
    
     public List<Token> searchToken(String tokenString) {
        Session session = NewHibernateUtil.getSessionAndBeginTransaction();
        try {
            String hql = "SELECT t FROM Token t Where t.tokenString LIKE :tokenString";
            Query query = session.createQuery(hql);
            query.setParameter("tokenString", "%"+tokenString+"%");
            
            return query.list(); //Get list
        } catch (Exception e) {
            NewHibernateUtil.rollBackCurrentSessions();
        } finally {
            try {
                NewHibernateUtil.commitCurrentSessions();
            } catch (Exception ex) {
                Logger.getLogger(TokenDao.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    NewHibernateUtil.closeCurrentSessions();
                } catch (Exception ex) {
                    Logger.getLogger(TokenDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return null;
    }    
   
}
