package alidesign.proxy.application.limitsubmithandler;

import alidesign.proxy.aopframe.annotation.LimitSubmitAnno;
import alidesign.proxy.aopframe.methodadvice.BaseMethodAdviceHandler;
import com.alibaba.fastjson.JSON;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * 拓展：限制单位时间内方法的调用次数，比如 3s 内用户只能提交表单 1 次
 *
 * @Author 喻可
 * @Date 2021/10/28 16:01
 */
@Component
public class LimitSubmitHandleHandler extends BaseMethodAdviceHandler<Object> {


    /**
     * 目标方法执行之前的判断，判断目标方法是否允许执行。默认返回 true，即 默认允许执行
     *
     * @param point 目标方法的连接点
     * @return 返回 true 则表示允许调用目标方法；返回 false 则表示禁止调用目标方法。
     * 当返回 false 时，此时会先调用 getOnForbid 方法获得被禁止执行时的返回值，然后
     * 调用 onComplete 方法结束切面
     */
    @Override
    public boolean onBefore(ProceedingJoinPoint point) {
        String jsonString = getMethodDesc(point);
        Map<String, Integer> parse = JSON.parseObject(jsonString, HashMap.class);
        //缓存记录下单位时间内用户的提交次数，如果超出最大调用次数，返回 false
        int recodeCount = 1;
        Integer unitTime = parse.get("unitTime");
        Integer count = parse.get("count");
        if (recodeCount > count) {
            return false;
        }
        return true;
    }

    /**
     * 禁止调用目标方法时（即 onBefore 返回 false），执行该方法获得返回值，默认返回 null
     *
     * @param point 目标方法的连接点
     * @return 禁止调用目标方法时的返回值
     */
    @Override
    public Object getOnForbid(ProceedingJoinPoint point) {
        // 获得返回值类型
        Class<?> returnType = getTargetMethod(point).getReturnType();

        // 如果返回值类型是 Map 或者其子类
        if (Map.class.isAssignableFrom(returnType)) {
            Map<String, Object> result = new HashMap<>(4);
            result.put("success", false);
            result.put("message", "调用次数超出限制");

            return result;
        }

        return null;
    }

    @Override
    protected String getMethodDesc(ProceedingJoinPoint point) {
        Method targetMethod = getTargetMethod(point);
        // 获得方法上的 InvokeRecordAnno
        LimitSubmitAnno anno = targetMethod.getAnnotation(LimitSubmitAnno.class);
        int unitTime = anno.unitTime();
        int count = anno.count();

        // 如果没有指定方法说明，那么使用默认的方法说明
        if (unitTime == 0 && count == 0) {
            unitTime = 3;
            count = 1;
        }

        HashMap<String, Integer> map = new HashMap<>(2);
        map.put("unitTime", unitTime);
        map.put("count", count);

        String jsonString = JSON.toJSONString(map);

        return jsonString;
    }
}
