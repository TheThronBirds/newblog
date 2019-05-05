package only.luzejin.newblog.service;

import only.luzejin.newblog.domain.User;

/**
 * 包名称only.luzejin.newblog.service
 * 接口名称UserService
 * 接口描述 TODO
 * 创建人luzejin
 * 创建时间2019/4/29 23:37
 **/
public interface UserService {

    /**
     * 添加用户
     * @param user
     * @return
     */
    public boolean addUser(User user);

    /**
     * 登录验证
     * @param username
     * @param password
     * @return
     */
    public int login(String username,String password);

    /**
     * 获取用户信息
     * @param username
     * @return
     */
    public User getUserByUsername(String username);
}
