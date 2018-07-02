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
public class UserSignInDto {
    private Long id;
    private String mobile;
    private String password;

    public UserSignInDto() {
    }

    public UserSignInDto(String mobile, String password) {
        this.mobile = mobile;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public String getMobile() {
        return mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
