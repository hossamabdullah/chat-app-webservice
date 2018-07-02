package dto;

public class UserSignUpDto  implements java.io.Serializable {
     private Long id;
     private String displayName;
     private String email;
     private String mobile;
     private String fullName;
     private String password;


    public UserSignUpDto() {
    }

	
    public UserSignUpDto(String mobile, String password) {
        this.mobile = mobile;
        this.password = password;
    }

    public UserSignUpDto(String displayName, String email, String mobile, String fullName, String password) {
        this.displayName = displayName;
        this.email = email;
        this.mobile = mobile;
        this.fullName = fullName;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getEmail() {
        return email;
    }

    public String getMobile() {
        return mobile;
    }

    public String getFullName() {
        return fullName;
    }

    public String getPassword() {
        return password;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object obj) {
        UserSignUpDto anotherUser = (UserSignUpDto)obj;
        return this.getMobile().equals(anotherUser.getMobile());
    }
}


