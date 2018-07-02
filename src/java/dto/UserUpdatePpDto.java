/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dto;

/**
 *
 * @author Hossam Abdallah
 */
public class UserUpdatePpDto {
    private Long id;
    private String mobile;
    private String profileImage;

    public UserUpdatePpDto() {
    }

    public UserUpdatePpDto(String mobile, String profileImage) {
        this.mobile = mobile;
        this.profileImage = profileImage;
    }

    public Long getId() {
        return id;
    }

    public String getMobile() {
        return mobile;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }
    
    
}
