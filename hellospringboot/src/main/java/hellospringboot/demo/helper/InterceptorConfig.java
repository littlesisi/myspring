package hellospringboot.demo.helper;

import hellospringboot.demo.interceptor.LogstInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created by admin on 2019/3/13 0013.
 */
@Configuration
public class InterceptorConfig  implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LogstInterceptor()).addPathPatterns("/**");
    }
}
