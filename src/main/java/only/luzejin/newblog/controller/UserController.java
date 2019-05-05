package only.luzejin.newblog.controller;

import eu.bitwalker.useragentutils.UserAgent;
import lombok.extern.slf4j.Slf4j;
import only.luzejin.newblog.Util.ProduceMD5;
import only.luzejin.newblog.dao.redisDao;
import only.luzejin.newblog.domain.LoginLog;
import only.luzejin.newblog.domain.User;
import only.luzejin.newblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import only.luzejin.newblog.dao.redisDao;

/**
 * 包名称only.luzejin.newblog.controller
 * 类名称UserController
 * 类描述 TODO
 * 创建人luzejin
 * 创建时间2019/5/5 9:38
 **/
@Controller
@RequestMapping("/User")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private redisDao redisDao;

    @RequestMapping("/loginCheck")
    @ResponseBody
    public Object signin(HttpServletRequest request, HttpSession session){
        //处理参数
        String password= ProduceMD5.getMD5(request.getParameter("password"));
        String username=request.getParameter("username");
        String checkcode = request.getParameter("checkcode");
        String realCheckcode = redisDao.getCheckCode("cCode");
        log.info("验证码{}",realCheckcode);

        HashMap<String, String> res = new HashMap<String, String>();

        if(!checkcode.equals(realCheckcode)){
            res.put("stateCode", "3");
            return res;
        }
        //验证用户名密码
        int loginVerify=userService.login(username,password);




        //登录成功
        if(loginVerify == 2){
            User user =userService.getUserByUsername(username);
            Integer userId=user.getId();
            //添加积分
            //boolean ifSuccAddCredit=userService.addCredit(1,userId);
            //用户信息写入session
            session.setAttribute("userId",userId);
            session.setAttribute("username",username);
            //获取登录信息
            String ip=getRemortIP(request);
            UserAgent userAgent = UserAgent.parseUserAgentString(request.getHeader("User-Agent"));
            //获取用户的浏览器名
            String userbrowser = userAgent.getBrowser().toString();
            //写入登录日志
            LoginLog log=new LoginLog();
            log.setDevice(userbrowser);
            log.setIp(ip);
            log.setUserId(userId);
            log.setLoginTime(new Date());
            //boolean ifSuccAddLog=loginLogService.addLog(log);

            res.put("stateCode", "2");
        }
        //密码错误
        else if (loginVerify == 1){
            res.put("stateCode", "1");
        }
        //用户名不存在
        else {
            res.put("stateCode", "0");
        }
        return res;
    }


    /**
     * 获取客户端IP
     */
    public String getRemortIP(HttpServletRequest request) {
        if (request.getHeader("x-forwarded-for") == null) {
            return request.getRemoteAddr();
        }
        return request.getHeader("x-forwarded-for");
    }
}
