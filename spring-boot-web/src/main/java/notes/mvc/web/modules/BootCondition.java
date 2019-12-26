package notes.mvc.web.modules;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * Description：满足条件才会创建Bean
 *
 * @author zzy520git
 * @date 2019/12/26 20:29
 * @ see
 * @since
 */
public class BootCondition implements Condition {
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        return true;
    }
}
