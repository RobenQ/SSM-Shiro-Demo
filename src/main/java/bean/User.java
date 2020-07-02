package bean;

public class User {
    private Integer id;
    private String userName;
    private String password;
    private String salt;
    private String perms;

    public User() {
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public User(Integer id, String userName, String password, String salt, String perms) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.salt = salt;
        this.perms = perms;
    }

    public Integer getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getPerms() {
        return perms;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPerms(String perms) {
        this.perms = perms;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", perms='" + perms + '\'' +
                '}';
    }
}
