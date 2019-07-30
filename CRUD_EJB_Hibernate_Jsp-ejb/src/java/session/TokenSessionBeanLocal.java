/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.Token;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author duy
 */
@Local
public interface TokenSessionBeanLocal {

    List<Token> getAll();

    List<Token> searchToken(String tokenString);

    boolean insert(String tokenStringInsert, int userIdInsert);

    boolean update(String tokenString, int userId);

    boolean delete(int userId);
    
}
