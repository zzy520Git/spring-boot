package notes.mvc.web.modules;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.zaxxer.hikari.HikariDataSource;
import notes.mvc.web.interceptor.ContextInterceptor;
import notes.mvc.web.interceptor.LoginInterceptor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.*;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import javax.sql.DataSource;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

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
//@ComponentScan
//@Import() 导入组件，id默认是全限定类名
public class ApplicationConfiguration extends WebMvcConfigurationSupport {
    //implements WebMvcConfigurer

    @Profile({"dev", "test", "prepublish", "production"})
    @Bean
    public LoginInterceptor loginInterceptor() {
        return new LoginInterceptor();
    }

    /**
     * @return
     * @Lazy
     * @Scope ...
     */
    @Conditional(BootCondition.class)
    @Bean
    //@Bean(initMethod = "", destroyMethod = "")
    //spring容器只管理单例bean，多例的不会执行destroy方法，在容器销毁时
    public ContextInterceptor contextInterceptor() {
        return new ContextInterceptor();
    }

    @Bean
    public MultipartResolver multipartResolver() {
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        //单位字节，设置-1代表不限制
        multipartResolver.setMaxUploadSize(10000000);
        multipartResolver.setDefaultEncoding("utf-8");
        return multipartResolver;
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

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {

        //1.先定义一个convert转换消息的对象
        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
        //2.添加fastjson的配置信息，比如：是否要格式化返回的json数据
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(
                SerializerFeature.PrettyFormat,
                SerializerFeature.WriteNullStringAsEmpty,
                SerializerFeature.WriteNullListAsEmpty
        );

        //处理中文乱码问题(不然出现中文乱码)
        List<MediaType> fastMediaTypes = new ArrayList<>();
        fastMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
        fastMediaTypes.add(MediaType.APPLICATION_JSON);
        fastMediaTypes.add(new MediaType(MediaType.TEXT_PLAIN, Charset.forName("UTF-8")));
        fastMediaTypes.add(new MediaType(MediaType.TEXT_HTML, Charset.forName("UTF-8")));
        fastConverter.setSupportedMediaTypes(fastMediaTypes);
        //3.在convertzhong 添加配置信息
        fastConverter.setFastJsonConfig(fastJsonConfig);
        //4.将convert添加到converters当中
        converters.add(fastConverter);

        StringHttpMessageConverter converter = new StringHttpMessageConverter(Charset.forName("UTF-8"));
        converters.add(converter);
        super.configureMessageConverters(converters);
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }
}
