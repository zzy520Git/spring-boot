package notes.mvc.web.modules;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

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
public class ApplicationConfiguration {
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }
}
