package notes.mvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Description：
 *
 * @author zzy520git
 * @date 2019/12/24 19:45
 * @ see
 * @since
 */
//@ImportResource(locations = {"classpath:spring/spring-jsf-bean.xml", "classpath:spring/spring-config.xml"})
//@MapperScan(basePackages = "notes.mvc.dao")
@SpringBootApplication
@EnableAspectJAutoProxy
@EnableTransactionManagement
public class SpringBootApp {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootApp.class, args);
    }
}
