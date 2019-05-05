package only.luzejin.newblog.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * 包名称only.luzejin.newblog.domain
 * 类名称LoginLog
 * 类描述 TODO
 * 创建人luzejin
 * 创建时间2019/5/5 9:56
 **/
@Getter
@Setter
public class LoginLog {

    private Long id;

    private Integer userId;

    private Date loginTime;

    private String ip;

    private String device;
}
