package countapi.rebuild2重构.reporter;

import countapi.rebuild1.entity.RequestInfo;
import countapi.rebuild1.entity.RequestStat;
import countapi.rebuild2重构.Aggregator;
import countapi.rebuild2重构.storage.MetricsStorage;
import countapi.rebuild2重构.viewer.StatViewer;

import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 上帝类
 * 负责组装这三个类，MetricsStorage，Aggregator，StatViewer
 * 将获取原始数据、聚合统计、显示统计结果到终端这三个阶段的工作串联起来，定时触发执行
 * <p>
 * 存在问题：ConsoleReporter、EmailReporter 类仍然存在代码重复、可测试性差
 *
 * @Author 喻可
 * @Date 2021/7/5 14:54
 */
public class ConsoleReporter {
    private MetricsStorage metricsStorage;
    private Aggregator aggregator;
    private StatViewer viewer;
    private ScheduledExecutorService executor;

    public ConsoleReporter(MetricsStorage metricsStorage, Aggregator aggregator, StatViewer viewer) {
        this.metricsStorage = metricsStorage;
        this.aggregator = aggregator;
        this.viewer = viewer;
        this.executor = Executors.newSingleThreadScheduledExecutor();
    }

    public void startRepeatedReport(long periodInSeconds, long durationInSeconds) {
        executor.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                long durationInMillis = durationInSeconds * 1000;
                long endTimeInMillis = System.currentTimeMillis();
                long startTimeInMillis = endTimeInMillis - durationInMillis;
                Map<String, List<RequestInfo>> requestInfos =
                        metricsStorage.getRequestInfos(startTimeInMillis, endTimeInMillis);
                Map<String, RequestStat> requestStats = aggregator.aggregate(requestInfos, durationInMillis);
                viewer.output(requestStats, startTimeInMillis, endTimeInMillis);
            }
        }, 0L, periodInSeconds, TimeUnit.SECONDS);
    }

}


