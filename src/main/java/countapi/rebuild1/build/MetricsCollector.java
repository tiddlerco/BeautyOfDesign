package countapi.rebuild1.build;

import countapi.rebuild1.build.stroage.MetricsStorage;
import countapi.rebuild1.entity.RequestInfo;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

/**
 * @Author 喻可
 * @Date 2021/6/22 10:23
 */
//负责提供 API，来采集接口请求的原始数据
@NoArgsConstructor
public class MetricsCollector {
    private MetricsStorage metricsStorage;//基于接口而非实现编程

    //依赖注入
    public MetricsCollector(MetricsStorage metricsStorage) {
        this.metricsStorage = metricsStorage;
    }

    //用一个函数代替了最小原型中的两个函数
    public void recordRequest(RequestInfo requestInfo) {
        if (requestInfo == null || StringUtils.isBlank(requestInfo.getApiName())) {
            return;
        }
        metricsStorage.saveRequestInfo(requestInfo);
    }
}

