package only.luzejin.newblog.domain;

import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * 包名称only.luzejin.newblog.domain
 * 类名称BaseDomain
 * 类描述 TODO
 * 创建人luzejin
 * 创建时间2019/5/5 9:51
 **/
public class BaseDomain implements Serializable {

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
