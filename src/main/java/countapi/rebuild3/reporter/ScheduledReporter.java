package countapi.rebuild3.reporter;

import countapi.rebuild1.entity.RequestInfo;
import countapi.rebuild1.entity.RequestStat;
import countapi.rebuild3.Aggregator;
import countapi.rebuild3.stroge.MetricsStorage;
import countapi.rebuild3.viewer.StatViewer;

import java.util.List;
import java.util.Map;

/**
 * 将reporter重复代码抽出来
 *
 * @Author 喻可
 * @Date 2021/7/5 18:15
 */

public abstract class ScheduledReporter {
    protected MetricsStorage metricsStorage;
    protected Aggregator aggregator;
    protected StatViewer viewer;

    public ScheduledReporter(MetricsStorage metricsStorage, Aggregator aggregator, StatViewer viewer) {
        this.metricsStorage = metricsStorage;
        this.aggregator = aggregator;
        this.viewer = viewer;
    }

    protected void doStatAndReport(long startTimeInMillis, long endTimeInMillis) {
        long durationInMillis = endTimeInMillis - startTimeInMillis;
        Map<String, List<RequestInfo>> requestInfos =
                metricsStorage.getRequestInfos(startTimeInMillis, endTimeInMillis);
        Map<String, RequestStat> requestStats = aggregator.aggregate(requestInfos, durationInMillis);
        viewer.output(requestStats, startTimeInMillis, endTimeInMillis);
    }

}