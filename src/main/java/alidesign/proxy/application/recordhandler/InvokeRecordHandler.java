package alidesign.proxy.application.recordhandler;

import alidesign.proxy.aopframe.annotation.InvokeRecordAnno;
import alidesign.proxy.aopframe.methodadvice.BaseMethodAdviceHandler;
import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * 方法增强处理器的实现
 *
 * @Author 喻可
 * @Date 2021/10/28 14:48
 */
@Component
public class InvokeRecordHandler extends BaseMethodAdviceHandler<Object> {

    /**
     * 记录方法出入参和调用时长
     */
    @Override
    public void onComplete(ProceedingJoinPoint point, long startTime, boolean permitted, boolean thrown, Object result) {
        String methodDesc = getMethodDesc(point);
        Object[] args = point.getArgs();
        long costTime = System.currentTimeMillis() - startTime;

        logger.warn("\n{} 执行结束，耗时={}ms，入参={}, 出参={}",
                methodDesc, costTime,
                JSON.toJSONString(args, true),
                JSON.toJSONString(result, true));
    }

    @Override
    protected String getMethodDesc(ProceedingJoinPoint point) {
        Method targetMethod = getTargetMethod(point);
        // 获得方法上的 InvokeRecordAnno
        InvokeRecordAnno anno = targetMethod.getAnnotation(InvokeRecordAnno.class);
        String description = anno.value();

        // 如果没有指定方法说明，那么使用默认的方法说明
        if (StringUtils.isBlank(description)) {
            description = (String) super.getMethodDesc(point);
        }

        return description;
    }
}
