package alidesign.strategy.factory;

import alidesign.strategy.handler.FormSubmitHandler;
import lombok.NonNull;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @title: 建立策略的简单工厂
 * @Author yuke
 * @Date: 2021/10/29 8:17
 */
@Component
public class FormSubmitHandlerFactory implements InitializingBean, ApplicationContextAware {

    private static final
    Map<String, FormSubmitHandler<Serializable>> FORM_SUBMIT_HANDLER_MAP = new HashMap<>(8);

    private ApplicationContext appContext;

    /**
     * 根据提交类型获取对应的处理器
     *
     * @param submitType 提交类型
     * @return 提交类型对应的处理器
     */
    public FormSubmitHandler<Serializable> getHandler(String submitType) {
        return FORM_SUBMIT_HANDLER_MAP.get(submitType);
    }

    @Override
    public void afterPropertiesSet() {
        // 将 Spring 容器中所有的 FormSubmitHandler 注册到 FORM_SUBMIT_HANDLER_MAP
        appContext.getBeansOfType(FormSubmitHandler.class)
                .values()
                .forEach(handler -> FORM_SUBMIT_HANDLER_MAP.put(handler.getSubmitType(), handler));
    }

    @Override
    public void setApplicationContext(@NonNull ApplicationContext applicationContext) {
        appContext = applicationContext;
    }
}
