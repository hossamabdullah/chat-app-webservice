/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao.utility;

import dao.UserDaoImpl;
import dao.UserDaoInt;

/**
 *
 * @author Hossam Abdallah
 */
public class DaoProvider {
    
    
    public static UserDaoInt getUserDao(){
        return new UserDaoImpl();
    }
}
