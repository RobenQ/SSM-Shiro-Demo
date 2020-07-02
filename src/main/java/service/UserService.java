package service;

import bean.User;

public interface UserService {
    public User selectUserByUserName(String userName);
    public User selectAll();
    public String selectPermsByUserName(String userName);
}
