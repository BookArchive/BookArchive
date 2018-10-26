package Comp271.BookArchive.BookArchive.DataModels;

public class User {

    private String username;
    private String password; //need to change this to something more secure
    private String major;

    public User(){}

    public User(String username,  String major){
        this.username = username;
        this.password = password;
        this.major = major;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }



}
