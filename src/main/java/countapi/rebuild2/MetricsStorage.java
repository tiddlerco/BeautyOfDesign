package countapi.rebuild2;

import countapi.rebuild1.entity.RequestInfo;

import java.util.List;
import java.util.Map;

/**
 * @Author 喻可
 * @Date 2021/6/22 10:24
 */
//负责原始数据存储
public interface MetricsStorage {
    void saveRequestInfo(RequestInfo requestInfo);

    List getRequestInfos(String apiName, long startTimeInMillis, long endTimeInMillis);

    Map<String, List<RequestInfo>> getRequestInfos(long startTimeInMillis, long endTimeInMillis);
}
