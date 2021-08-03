package countapi.rebuild4易用性;

import countapi.rebuild1.entity.RequestInfo;
import countapi.rebuild3代码优化去重.stroge.MetricsStorage;
import countapi.rebuild3代码优化去重.stroge.RedisMetricsStorage;
import org.apache.commons.lang3.StringUtils;


/**
 * @Author 喻可
 * @Date 2021/7/5 22:56
 */

public class MetricsCollector {

    private MetricsStorage metricsStorage;

    // 兼顾代码的易用性，新增一个封装了默认依赖的构造函数
    public MetricsCollector() {
        this(new RedisMetricsStorage());
    }

    // 兼顾灵活性和代码的可测试性，这个构造函数继续保留
    public MetricsCollector(MetricsStorage metricsStorage) {
        this.metricsStorage = metricsStorage;
    }
    // 省略其他代码...
    public void recordRequest(RequestInfo requestInfo) {
        if (requestInfo == null || StringUtils.isBlank(requestInfo.getApiName())) {
            return;
        }
        metricsStorage.saveRequestInfo(requestInfo);
    }
}




