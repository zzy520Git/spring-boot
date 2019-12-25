package notes.mvc.web.modules;

import com.zaxxer.hikari.HikariDataSource;
import notes.mvc.web.interceptor.ContextInterceptor;
import notes.mvc.web.interceptor.LoginInterceptor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import javax.sql.DataSource;

/**
 * Description：@Configuration自动扫描
 *
 * @author zzy520git
 * @date 2019/12/24 21:07
 * @ see
 * @since
 */
@PropertySources({@PropertySource(value = "classpath:/important.properties", encoding = "utf-8")})
@Configuration
public class ApplicationConfiguration extends WebMvcConfigurationSupport {
    //implements WebMvcConfigurer

    @Bean
    public LoginInterceptor loginInterceptor() {
        return new LoginInterceptor();
    }

    @Bean
    public ContextInterceptor contextInterceptor() {
        return new ContextInterceptor();
    }

    /**
     * 拦截器配置
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //todo /static/*代表只当前目录；/static/** 代表当前目录及其子目录；
        registry.addInterceptor(loginInterceptor()).addPathPatterns("/**").excludePathPatterns("/static/*", "/assets/**/*");
        registry.addInterceptor(contextInterceptor()).addPathPatterns("/**").excludePathPatterns("/static/**", "/assets/**/*");
        super.addInterceptors(registry);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //todo 重点：不能写成classpath:/static/**
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("/assets/**").addResourceLocations("classpath:/assets/");
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }
}
