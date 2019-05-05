package only.luzejin.newblog.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 包名称only.luzejin.newblog.config
 * 类名称WebConfig
 * 类描述 TODO
 * 创建人luzejin
 * 创建时间2019/5/4 17:00
 **/
@Configuration
public abstract class WebConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        registry.addResourceHandler("/css/**").addResourceLocations("/static/css/");
        registry.addResourceHandler("/js/**").addResourceLocations("/static/js/");
        registry.addResourceHandler("/img/**").addResourceLocations("/static/img/");
    }

}
