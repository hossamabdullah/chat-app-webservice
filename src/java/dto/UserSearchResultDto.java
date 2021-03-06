package dto;
// Generated Mar 27, 2015 12:37:07 AM by Hibernate Tools 3.6.0


import java.util.HashSet;
import java.util.Set;

/**
 * User generated by hbm2java
 */
public class UserSearchResultDto  implements java.io.Serializable {


     private Long id;
     private String displayName;
     private String email;
     private String mobile;
     private String fullName;
     private String profileImage;
     private Boolean activated;
     private Boolean confirmed;
     private Set blockForBlocking = new HashSet(0);
     private Set blockForBlocked = new HashSet(0);
     private Set friendshipsForUser = new HashSet(0);
     private Set friendshipsForFriend = new HashSet(0);

    public UserSearchResultDto() {
    }

	
    public UserSearchResultDto(String mobile) {
        this.mobile = mobile;
    }
    public UserSearchResultDto(String displayName, String email, String mobile, String fullName,String profileImage, Boolean activated, Boolean confirmed, Set blockForBlocking, Set blockForBlocked, Set friendshipsForUser, Set friendshipsForFriend) {
       this.displayName = displayName;
       this.email = email;
       this.mobile = mobile;
       this.fullName = fullName;
       this.profileImage = profileImage;
       this.activated = activated;
       this.confirmed = confirmed;
       this.blockForBlocking = blockForBlocking;
       this.blockForBlocked = blockForBlocked;
       this.friendshipsForUser = friendshipsForUser;
       this.friendshipsForFriend = friendshipsForFriend;
    }
   
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    public String getDisplayName() {
        return this.displayName;
    }
    
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    public String getMobile() {
        return this.mobile;
    }
    
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    public String getFullName() {
        return this.fullName;
    }
    
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    
    public Boolean getActivated() {
        return this.activated;
    }
    
    public void setActivated(Boolean activated) {
        this.activated = activated;
    }
    public Boolean getConfirmed() {
        return this.confirmed;
    }
    
    public void setConfirmed(Boolean confirmed) {
        this.confirmed = confirmed;
    }

    public Set getBlockForBlocking() {
        return blockForBlocking;
    }

    public void setBlockForBlocking(Set blockForBlocking) {
        this.blockForBlocking = blockForBlocking;
    }
    
    public Set getBlockForBlocked() {
        return this.blockForBlocked;
    }
    
    public void setBlockForBlocked(Set blockForBlocked) {
        this.blockForBlocked = blockForBlocked;
    }
    public Set getFriendshipsForUser() {
        return this.friendshipsForUser;
    }
    
    public void setFriendshipsForUser(Set friendshipsForUser) {
        this.friendshipsForUser = friendshipsForUser;
    }
    public Set getFriendshipsForFriend() {
        return this.friendshipsForFriend;
    }
    
    public void setFriendshipsForFriend(Set friendshipsForFriend) {
        this.friendshipsForFriend = friendshipsForFriend;
    }




}


