package countapi.rebuild5;

import countapi.rebuild1.entity.RequestInfo;
import countapi.rebuild1.entity.RequestStat;
import countapi.rebuild3.Aggregator;
import countapi.rebuild3.stroge.MetricsStorage;
import countapi.rebuild3.viewer.StatViewer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 当统计的时间间隔较大的时候，需要统计的数据量就会比较大。
 * 我们可以将其划分为一些小的时间区间（比如 10 分钟作为一个统计单元），
 * 针对每个小的时间区间分别进行统计，然后将统计得到的结果再进行聚合，
 * 得到最终整个时间区间的统计结果
 *
 * @Author 喻可
 * @Date 2021/7/6 8:32
 */

public class ScheduleReporter {
    private static final long MAX_STAT_DURATION_IN_MILLIS = 10 * 60 * 1000; // 10minutes

    protected MetricsStorage metricsStorage;
    protected Aggregator aggregator;
    protected StatViewer viewer;

    public ScheduleReporter(MetricsStorage metricsStorage, Aggregator aggregator, StatViewer viewer) {
        this.metricsStorage = metricsStorage;
        this.aggregator = aggregator;
        this.viewer = viewer;
    }

    protected void doStatAndReport(long startTimeInMillis, long endTimeInMillis) {
        Map<String, RequestStat> stats = doStat(startTimeInMillis, endTimeInMillis);
        viewer.output(stats, startTimeInMillis, endTimeInMillis);
    }

    private Map<String, RequestStat> doStat(long startTimeInMillis, long endTimeInMillis) {
        Map<String, List<RequestStat>> segmentStats = new HashMap<>();
        long segmentStartTimeMillis = startTimeInMillis;
        //这里进行分段统计
        while (segmentStartTimeMillis < endTimeInMillis) {
            long segmentEndTimeMillis = segmentStartTimeMillis + MAX_STAT_DURATION_IN_MILLIS;
            if (segmentEndTimeMillis > endTimeInMillis) {
                segmentEndTimeMillis = endTimeInMillis;
            }
            Map<String, List<RequestInfo>> requestInfos =
                    metricsStorage.getRequestInfos(segmentStartTimeMillis, segmentEndTimeMillis);
            if (requestInfos == null || requestInfos.isEmpty()) {
                continue;
            }
            Map<String, RequestStat> segmentStat = aggregator.aggregate(
                    requestInfos, segmentEndTimeMillis - segmentStartTimeMillis);
            addStat(segmentStats, segmentStat);
            segmentStartTimeMillis += MAX_STAT_DURATION_IN_MILLIS;
        }

        long durationInMillis = endTimeInMillis - startTimeInMillis;
        Map<String, RequestStat> aggregatedStats = aggregateStats(segmentStats, durationInMillis);
        return aggregatedStats;
    }

    private void addStat(Map<String, List<RequestStat>> segmentStats,
                         Map<String, RequestStat> segmentStat) {

        segmentStat.forEach((key, value) -> {
            List<RequestStat> list = segmentStats.get(key);
            list.add(value);
            segmentStats.put(key, list);
        });

    }

    //做聚合分析
    private Map<String, RequestStat> aggregateStats(Map<String, List<RequestStat>> segmentStats,
                                                    long durationInMillis) {
        Map<String, RequestStat> aggregatedStats = new HashMap<>();
        for (Map.Entry<String, List<RequestStat>> entry : segmentStats.entrySet()) {
            String apiName = entry.getKey();
            List<RequestStat> apiStats = entry.getValue();
            double maxRespTime = Double.MIN_VALUE;
            double minRespTime = Double.MAX_VALUE;
            long count = 0;
            double sumRespTime = 0;
            for (RequestStat stat : apiStats) {
                if (stat.getMaxResponseTime() > maxRespTime) maxRespTime = stat.getMaxResponseTime();
                if (stat.getMinResponseTime() < minRespTime) minRespTime = stat.getMinResponseTime();
                count += stat.getCount();
                sumRespTime += (stat.getCount() * stat.getAvgResponseTime());
            }
            RequestStat aggregatedStat = new RequestStat();
            aggregatedStat.setMaxResponseTime(maxRespTime);
            aggregatedStat.setMinResponseTime(minRespTime);
            aggregatedStat.setAvgResponseTime(sumRespTime / count);
            aggregatedStat.setCount(count);
            aggregatedStat.setTps(count / durationInMillis * 1000);
            aggregatedStats.put(apiName, aggregatedStat);
        }
        return aggregatedStats;
    }
}