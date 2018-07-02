/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import dto.UserSearchResultDto;
import dto.UserSignUpDto;
import dto.UserUpdatePpDto;
import java.util.logging.Level;
import java.util.logging.Logger;
import logic.utility.MainUtility;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.TransactionException;
import pojo.User;
import utility.NewHibernateUtil;

/**
 *
 * @author Hossam Abdallah
 */
public class UserDaoImpl implements UserDaoInt{
//    Session session ;
//    private static final UserDaoImpl userDaoImpl;
    
//    static{
//        userDaoImpl = new UserDaoImpl();
//    }
    
    public UserDaoImpl() {
//        session = NewHibernateUtil.getSessionFactory().openSession();
    }

//    public static UserDaoImpl getUserDaoImpl() {
//        return userDaoImpl;
//    }
    
    private boolean isMobExist(String mob){
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Query getUser = session.createQuery("from User u where u.mobile = :mob").setString("mob", mob);
        User user = (User)getUser.uniqueResult();
        if(user == null ){
            session.close();
            return false;
        }else{
            session.close();
            return true;
        }
    }
    
    @Override
    public boolean insertUser(UserSignUpDto userDto) {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        User user = new User(userDto.getDisplayName(), userDto.getEmail(), userDto.getMobile(), userDto.getFullName(), null, userDto.getPassword(),null, null, null, null,null,null);
        final String mob = userDto.getMobile();
        final String email = userDto.getEmail();
        System.out.println("http://127.0.0.1:3000/confirm?userkey="+MainUtility.encrypt(mob));
        if(!isMobExist(mob)){
            session.persist(user);
            session.getTransaction().commit();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    MainUtility.sendMessage("Confirm Your Account", "please go to the following url to confirm your account: \n"+"http://127.0.0.1:3000/confirm?userkey="+MainUtility.encrypt(mob), email);
                }
            }).start();
            session.close();
            return true;
        }else{
            session.getTransaction().rollback();
            session.close();
            return false;
        }
    }
    
    /**
     * search for user with the given mobile and returns it
     * 
     * @param mobile key to search for user with it
     * @return  UserSearchResultDto object that contains the data of the selected user
     * or return null if no user found with that mobile
     */
    @Override
    public UserSearchResultDto getUser(String mobile) {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Query getUser = session.createQuery("from User u where u.mobile = :mob").setString("mob", mobile);
        User user = (User)getUser.uniqueResult();
        if(user == null){
            session.close();
            return null;
        }else{

             UserSearchResultDto userDto = new UserSearchResultDto(user.getDisplayName(), user.getEmail(), user.getMobile(), user.getFullName(), user.getProfileImage() , user.getActivated(), user.getConfirmed(), user.getUsersForBlockingId(), user.getUsersForBlockedId(), user.getFriendshipsForUserId(), user.getFriendshipsForFriendId());
             session.close();
            return userDto;
        }
    }
    
    @Override
    public UserSearchResultDto getUser(String mobile, String password) {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        System.out.println(mobile +" ,      s "+password );
        Query getUser = session.createQuery("from User u where u.mobile = :mob and u.password = :pass and u.confirmed = true").setString("mob", mobile).setString("pass", password);
        User user = (User)getUser.uniqueResult();
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"+user);
        if(user == null){
            session.close();
            return null;
        }else{
            UserSearchResultDto userDto = new UserSearchResultDto(user.getDisplayName(), user.getEmail(), user.getMobile(), user.getFullName(), user.getProfileImage(), user.getActivated(), user.getConfirmed(), user.getUsersForBlockingId(), user.getUsersForBlockedId(), user.getFriendshipsForUserId(), user.getFriendshipsForFriendId());
            session.close();
            return userDto;
        }
    }
    
    @Override
    public boolean updateUser(UserSignUpDto newUser) {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        System.out.println("im innnnnnnn EDITEDIT");
        System.out.println(newUser.getMobile()+" the mobile EDIEDIT");
        Query getUser = session.createQuery("from User u where u.mobile = :mob").setString("mob", newUser.getMobile());
        User oldUser = (User)getUser.uniqueResult();
        System.out.println("old user is="+oldUser+"EDITEDIT");
        if(oldUser == null){
            session.getTransaction().rollback();
            session.close();
            return false;
        }
        else{
            if(newUser.getDisplayName() != null)
                oldUser.setDisplayName(newUser.getDisplayName());
            if(newUser.getEmail() != null)
                oldUser.setEmail(newUser.getEmail());
            if(newUser.getMobile() != null)    
                oldUser.setMobile(newUser.getMobile());
            if(newUser.getFullName() != null )
                oldUser.setFullName(newUser.getFullName());
            if(newUser.getPassword() != null)
                oldUser.setPassword(newUser.getPassword());
            System.out.println("Saving New User");
            session.saveOrUpdate(oldUser);
            session.getTransaction().commit();
            session.close();
            return true;
        }
    }
    
    @Override
    public boolean updatePp(UserUpdatePpDto userDto) {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            System.out.println(userDto.getMobile());
            System.out.println("1111111111111111111");
            Query getUser = session.createQuery("from User u where u.mobile = :mob").setString("mob", userDto.getMobile());
            User user = (User) getUser.uniqueResult();
            System.out.println(user);
            if(user == null){
                System.out.println("222222222222222222222");
                session.getTransaction().commit();
                session.close();
                return false;
            }
            System.out.println("3333333333333333333333333");
            user.setProfileImage(userDto.getProfileImage());
            session.saveOrUpdate(user);
            session.getTransaction().commit();
            System.out.println("444444444444444444444444");
            session.close();
            return true;
        }catch(TransactionException tex){
            try {
                Thread.sleep(1000);
                System.out.println("55555555555555555555555");
            } catch (InterruptedException ex) {
                Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
            session.close();
            return updatePp(userDto);
        }
    }
    
    @Override
    public String getPassword(String mobile) {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Query getUser = session.createQuery("from User u where u.mobile = :mob").setString("mob", mobile);
        User user = (User)getUser.uniqueResult();
        if(user == null){
            session.close();
            return null;
        }else{
            session.close();
            return user.getPassword();
        }
    }
    
    @Override
    public boolean confirmUser(String decryptedMobile) {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        String mobile = MainUtility.decrypt(decryptedMobile);
        System.out.println("The real mobile was : "+mobile);
        Query getUser = session.createQuery("from User u where u.mobile = :mob").setString("mob", mobile);
        User user = (User)getUser.uniqueResult();
        if(user == null){
            session.getTransaction().rollback();
            session.close();
            return false;
        }else{
            System.out.println(user.getMobile() +"im in cofirm user");
            user.setConfirmed(Boolean.TRUE);
            session.saveOrUpdate(user);
            session.getTransaction().commit();
            session.refresh(user);
            System.out.println(user.getConfirmed() +"im in cofirm user");
            session.close();
            return true;
        }
    }
    @Override
    public String getEmail(String mobile) {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Query getUser = session.createQuery("from User u where u.mobile = :mob").setString("mob", mobile);
        User user = (User)getUser.uniqueResult();
        if(user == null){
            session.close();
            return null;
        }else{
            session.close();
            return user.getEmail();
        }
    }

//    @Override
//    protected void finalize() throws Throwable {
//        session.close();
//    }

   
    

   

    

    
}
