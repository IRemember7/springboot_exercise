package life.majiang.community.service;

import life.majiang.community.dao.UserMapper;
import life.majiang.community.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public User userLogin(String accountId,String userPassword){
        User user = userMapper.userLogin(accountId,userPassword);
        return user;
    }

    public int registerUser(User user) {
        return userMapper.registerUser(user);
    }
}
