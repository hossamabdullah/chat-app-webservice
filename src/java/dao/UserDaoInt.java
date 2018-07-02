/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import dto.UserSearchResultDto;
import dto.UserSignUpDto;
import dto.UserUpdatePpDto;

/**
 *
 * @author Hossam Abdallah
 */
public interface UserDaoInt {

    public boolean insertUser(UserSignUpDto user);
    
    /**
     * search for user with the given mobile and returns it
     * 
     * @param mobile key to search for user with it
     * @return  UserSearchResultDto object that contains the data of the selected user
     * or return null if no user found with that mobile
     */
    public UserSearchResultDto getUser(String mobile);
    
    public UserSearchResultDto getUser(String mobile,String password);

    public boolean updateUser(UserSignUpDto user);
    
    public boolean updatePp(UserUpdatePpDto userDto);
    
    public String getPassword(String mobile);

    public boolean confirmUser(String decryptedMobile);

    public String getEmail(String mobile);
}
