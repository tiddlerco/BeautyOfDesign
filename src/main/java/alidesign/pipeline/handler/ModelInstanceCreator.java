package alidesign.pipeline.handler;

import alidesign.pipeline.pipeline.InstanceBuildContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @Author 喻可
 * @Date 2021/10/27 17:14
 */
@Component
public class ModelInstanceCreator implements ContextHandler<InstanceBuildContext> {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public boolean handle(InstanceBuildContext context) {
        logger.info("--根据输入数据创建模型实例--");

        // 假装创建模型实例

        return true;
    }
}
