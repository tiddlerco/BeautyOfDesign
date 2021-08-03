package countapi.rebuild3代码优化去重.stroge;


import countapi.rebuild1.entity.RequestInfo;

import java.util.List;
import java.util.Map;

/**
 * @Author 喻可
 * @Date 2021/6/22 10:25
 */

public class RedisMetricsStorage implements MetricsStorage {
    //...省略属性和构造函数等...
    @Override
    public void saveRequestInfo(RequestInfo requestInfo) {
        //...
    }

    @Override
    public List<RequestInfo> getRequestInfos(String apiName, long startTimestamp, long endTimestamp) {
        //...
        return null;
    }

    @Override
    public Map<String, List<RequestInfo>> getRequestInfos(long startTimestamp, long endTimestamp) {
        //...
        return null;
    }
}
