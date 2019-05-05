package only.luzejin.newblog;

import only.luzejin.newblog.dao.UserMapper;
import only.luzejin.newblog.domain.User;
import only.luzejin.newblog.service.UserService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 包名称only.luzejin.newblog
 * 类名称test
 * 类描述 TODO
 * 创建人luzejin
 * 创建时间2019/4/27 22:07
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = NewblogApplication.class)
public class test {

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Autowired
    private UserService userService;

    @Test
    public void testCache(){
         /*SqlSession sqlsession = sqlSessionFactory.openSession();
         UserMapper userMapper =  sqlsession.getMapper(UserMapper.class);

         System.out.println(userMapper.selectByPrimaryKey(1));
         System.out.println("--------------------");
         System.out.println(userMapper.selectByPrimaryKey(1));*/

         User user = new User();
         user.setUsername("zhangsan");
         user.setPassword("123456");
         user.setPhoneNum("123");
         user.setCredit(0);
         user.setId(112);

         userService.addUser(user);


    }
}
