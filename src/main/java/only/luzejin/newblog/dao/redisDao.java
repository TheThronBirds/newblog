package only.luzejin.newblog.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 包名称only.luzejin.newblog.dao
 * 类名称redisDao
 * 类描述 TODO
 * 创建人luzejin
 * 创建时间2019/5/4 23:32
 **/
@Service
public class redisDao {


    @Resource
    protected ValueOperations<String, Object> valueOperations;

    public void setCheckCode(String key,String value){
        valueOperations.set(key,value);
    }

    public String  getCheckCode(String key){
        return valueOperations.get(key).toString();
    }
}
