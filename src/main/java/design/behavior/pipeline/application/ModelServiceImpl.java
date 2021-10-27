package design.behavior.pipeline.application;

import design.behavior.pipeline.executor.PipelineExecutor;
import design.behavior.pipeline.pipeline.InstanceBuildContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.util.concurrent.ExecutionException;

/**
 * @Author 喻可
 * @Date 2021/10/27 17:28
 */
public class ModelServiceImpl {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private PipelineExecutor pipelineExecutor;
    /**
     * 提交模型（构建模型实例）
     */
    public boolean buildModelInstance(InstanceBuildRequest request) throws ExecutionException, InterruptedException {
        InstanceBuildContext data = createPipelineData(request);
        //异步获取
        boolean success = pipelineExecutor.acceptAsync(data,null);

        // 创建模型实例成功
        if (success) {
            return true;
        }

        logger.error("创建模式实例失败：{}", data.getErrorMsg());
        return false;
    }

    private InstanceBuildContext createPipelineData(InstanceBuildRequest request) {
        return null;
    }

    public static class InstanceBuildRequest {

    }

}
