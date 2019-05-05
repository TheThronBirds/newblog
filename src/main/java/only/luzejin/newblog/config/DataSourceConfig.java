package only.luzejin.newblog.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * 包名称only.luzejin.newblog.config
 * 类名称DataSourceConfig
 * 类描述 数据源配置
 * 创建人luzejin
 * 创建时间2019/4/26 14:54
 **/
@Configuration
public class DataSourceConfig {

    @Value("${only.luzejin.dataSource.maxPoolSize:100}")
    private int maxPoolSize;
    @Value("${only.luzejin.dataSource.minIdle:50}")
    private int minIdle;

    @Primary
    @Bean
    @ConfigurationProperties("only.luzejin.dataSource")
    public DataSource getDataSource(){
        HikariDataSource hikariDataSource = new HikariDataSource();
        hikariDataSource.setMinimumIdle(maxPoolSize);
        hikariDataSource.setMinimumIdle(minIdle);
        return hikariDataSource;
    }

}
