package only.luzejin.newblog.controller;

import only.luzejin.newblog.Util.Captcha;
import only.luzejin.newblog.dao.redisDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.OutputStream;

/**
 * 包名称only.luzejin.newblog.controller
 * 类名称MainController
 * 类描述 TODO
 * 创建人luzejin
 * 创建时间2019/5/4 15:58
 **/
@Controller
public class MainController {

    @Autowired
    private redisDao redisDao;

    @RequestMapping(value = {"/signin"})
    public ModelAndView signin(){
        ModelAndView signinPage=new ModelAndView("signin");

        //获取统计信息
        /*int topicsNum=topicService.getTopicsNum();
        int usersNum=userService.getUserCount();

        signinPage.addObject("topicsNum",topicsNum);
        signinPage.addObject("usersNum",usersNum);*/
        return  signinPage;
    }


    /**
     * 生成验证码
     * @param res
     * @throws IOException
     */
    @RequestMapping("/checkcode")
    public void drawCheckcode(HttpServletResponse res) throws IOException {
        res.setContentType("image/jpg");
        int width = 70;
        int height = 25;
        Captcha c = Captcha.getInstance();
        c.set(width, height);
        String checkcode = c.generateCheckcode();
        OutputStream os = res.getOutputStream();
        redisDao.setCheckCode("cCode",checkcode);
        ImageIO.write(c.generateCheckImg(checkcode), "jpg", os);
    }
}
