package only.luzejin.newblog.domain;

import com.fasterxml.jackson.databind.ser.Serializers;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 包名称only.luzejin.newblog.domain
 * 类名称User
 * 类描述 用户实体类
 * 创建人luzejin
 * 创建时间2019/4/26 13:15
 **/
@Getter
@Setter
@ToString
@NoArgsConstructor
public class User extends BaseDomain{

    /**
     * 用户编号
     */
    private Integer id;

    /**
     * 用户名称
     */
    private String username;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 用户邮箱
     */
    private String email;

    /**
     * 用户号码
     */
    private String phoneNum;

    /**
     * 用户创建时间
     */
    private Date createTime;

    /**
     * 用户信息更新时间
     */
    private Date updateTime;

    /**
     * 用户积分
     */
    private Integer credit;

    /**
     * 用户头像路径
     */
    private String avatar;

    /**
     * 暂定
     */
    private Byte tyte;

    public String getLocalCreateTime(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        return df.format(this.createTime);
    }

    public String getLocalUpdateTime(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH mm");
        return df.format(this.updateTime);
    }
}
