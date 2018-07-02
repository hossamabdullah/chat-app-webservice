package pojo;
// Generated Mar 30, 2015 11:13:48 AM by Hibernate Tools 3.6.0



/**
 * Friendship generated by hbm2java
 */
public class Friendship  implements java.io.Serializable {


     private FriendshipId id;
     private User userByUserId;
     private User userByFriendId;
     private boolean binding;

    public Friendship() {
    }

    public Friendship(FriendshipId id, User userByUserId, User userByFriendId, boolean binding) {
       this.id = id;
       this.userByUserId = userByUserId;
       this.userByFriendId = userByFriendId;
       this.binding = binding;
    }
   
    public FriendshipId getId() {
        return this.id;
    }
    
    public void setId(FriendshipId id) {
        this.id = id;
    }
    public User getUserByUserId() {
        return this.userByUserId;
    }
    
    public void setUserByUserId(User userByUserId) {
        this.userByUserId = userByUserId;
    }
    public User getUserByFriendId() {
        return this.userByFriendId;
    }
    
    public void setUserByFriendId(User userByFriendId) {
        this.userByFriendId = userByFriendId;
    }
    public boolean isBinding() {
        return this.binding;
    }
    
    public void setBinding(boolean binding) {
        this.binding = binding;
    }




}

