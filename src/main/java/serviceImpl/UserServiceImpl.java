package serviceImpl;

import bean.User;
import mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.UserService;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User selectUserByUserName(String userName) {
        return userMapper.selectUserByUserName(userName);
    }

    @Override
    public User selectAll() {
        return userMapper.selectAll();
    }

    @Override
    public String selectPermsByUserName(String userName) {
        return userMapper.selectPermsByUserName(userName);
    }
}
