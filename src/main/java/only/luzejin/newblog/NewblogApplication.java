package only.luzejin.newblog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement(proxyTargetClass = false)
public class NewblogApplication {

    public static void main(String[] args) {
        SpringApplication.run(NewblogApplication.class, args);
    }


}
