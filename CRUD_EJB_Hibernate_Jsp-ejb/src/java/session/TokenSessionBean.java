/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import dao.TokenDao;
import entity.Token;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author duy
 */
@Stateless
public class TokenSessionBean implements TokenSessionBeanLocal {

    @Override
    public List<Token> getAll() {
        TokenDao dao = new TokenDao();
        return dao.getAll();
    }
    
    

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public List<Token> searchToken(String tokenString) {
        TokenDao dao = new TokenDao();
        return dao.searchToken(tokenString);
    }

    @Override
    public boolean insert(String tokenStringInsert, int userIdInsert) {
        TokenDao dao = new TokenDao();
        return dao.insertToken(tokenStringInsert, userIdInsert);
    }

    @Override
    public boolean update(String tokenString, int userId) {
        TokenDao dao = new TokenDao();
        return dao.updateToken(tokenString, userId);
    }

    @Override
    public boolean delete(int userId) {
        TokenDao dao = new TokenDao();
        return dao.deleteToken(userId);
    }
}
