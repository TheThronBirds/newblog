package only.luzejin.newblog.service.impl;

import only.luzejin.newblog.dao.UserMapper;
import only.luzejin.newblog.domain.User;
import only.luzejin.newblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 包名称only.luzejin.newblog.service.impl
 * 类名称UserServiceImpl
 * 类描述 TODO
 * 创建人luzejin
 * 创建时间2019/4/29 23:41
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    @Transactional
    public boolean addUser(User user) {
        int flag = userMapper.addUser(user);
        if(flag > 0){
            return true;
        }
        return false;
    }

    /**
     * 登录验证 0:用户名不存在 1:密码错误 2:验证成功
     * @param username
     * @param password
     * @return
     */
    @Override
    public int login(String username, String password) {
        //判断username是否存在
        boolean existUsername=existUsername(username);
        //若username存在，验证密码
        if (existUsername){
            User resUser=userMapper.selectByUsername(username);
            if (resUser.getPassword().equals(password)){
                return 2;
            }
            return 1;
        }
        return 0;
    }

    @Override
    public User getUserByUsername(String username) {
        User resUser=userMapper.selectByUsername(username);
        return resUser;
    }

    /**
     * username是否存在
     * @param username
     * @return
     */
    public boolean existUsername(String username) {

        return userMapper.existUsername(username)==1;
    }


}
