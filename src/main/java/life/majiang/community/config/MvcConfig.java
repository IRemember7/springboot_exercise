package life.majiang.community.config;

import life.majiang.community.util.FileSave;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login.html").setViewName("login");
        registry.addViewController("/publish.html").setViewName("publish");
        registry.addViewController("/register.html").setViewName("register");
    }

    /*
            添加资源管理器映射文件地址
     */

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/files/**").addResourceLocations("file:"+ FileSave.FILE_UPLOAD_PATH);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
                /*
        添加拦截器
        /**  代表拦截所有请求
        excludePathPatterns  代表除某些请求外
        静态资源不会拦截
         */
        registry.addInterceptor(new ProfileHandlerInterceptor()).addPathPatterns("/profile/**");


    }
}
