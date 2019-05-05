package only.luzejin.newblog.dao;

import only.luzejin.newblog.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 包名称only.luzejin.newblog.dao
 * 接口名称UserMapper
 * 接口描述 TODO
 * 创建人luzejin
 * 创建时间2019/4/27 22:33
 **/
@Mapper
public interface UserMapper {

    int deleteByPrimaryKey(Integer id);

    //用户注册
    int addUser(User user);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);


    User selectByUsername(String username);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    //多参数注解
    int addCredit(@Param("points") Integer points, @Param("id")Integer id);

    //查询username是否存在
    int existUsername(String username);

    //查询用户数
    int getUserCount();
}
