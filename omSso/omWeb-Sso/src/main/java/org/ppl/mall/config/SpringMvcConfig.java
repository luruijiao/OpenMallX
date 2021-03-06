package org.ppl.mall.config;

import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


/**
 * springmvc配置
 * @author PPL
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages="org.ppl.mall.controller.sso")
@Import({DubboConfig.class})
@PropertySource({
        "classpath:conf/redis.properties",
        "classpath:conf/sso.properties"
})
public class SpringMvcConfig extends WebMvcConfigurerAdapter {

    //视图解析器
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/jsp/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        //静态资源不要经过DispatcherServlet
        configurer.enable();
    }
}
