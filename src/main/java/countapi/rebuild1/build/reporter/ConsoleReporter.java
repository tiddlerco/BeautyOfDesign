package countapi.rebuild1.build.reporter;

import com.google.gson.Gson;
import countapi.rebuild1.build.Aggregator;
import countapi.rebuild1.build.stroage.MetricsStorage;
import countapi.rebuild1.entity.RequestInfo;
import countapi.rebuild1.entity.RequestStat;

import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 存在问题：
 * 1.ConsoleReporter和EmailReporter 两个类中存在代码重复问题
 * 2.整个类负责的事情比较多，不相干的逻辑糅合在里面，职责不够单一。
 * 特别是显示部分的代码可能会比较复杂（比如 Email 的显示方式），
 * 最好能将这部分显示逻辑剥离出来，设计成一个独立的类
 *
 * @Author 喻可
 * @Date 2021/6/22 10:27
 */

public class ConsoleReporter {
    private MetricsStorage metricsStorage;
    private ScheduledExecutorService executor;

    public ConsoleReporter(MetricsStorage metricsStorage) {
        this.metricsStorage = metricsStorage;
        this.executor = Executors.newSingleThreadScheduledExecutor();
    }

    // 第4个代码逻辑：定时触发第1、2、3代码逻辑的执行；
    public void startRepeatedReport(long periodInSeconds, long durationInSeconds) {
        executor.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                // 第1个代码逻辑：根据给定的时间区间，从数据库中拉取数据；
                long durationInMillis = durationInSeconds * 1000;
                long endTimeInMillis = System.currentTimeMillis();
                long startTimeInMillis = endTimeInMillis - durationInMillis;
                Map<String, List<RequestInfo>> requestInfos =
                        metricsStorage.getRequestInfos(startTimeInMillis, endTimeInMillis);
                Map<String, RequestStat> stats = new HashMap<>();
                for (Map.Entry<String, List<RequestInfo>> entry : requestInfos.entrySet()) {
                    String apiName = entry.getKey();
                    List<RequestInfo> requestInfosPerApi = entry.getValue();
                    // 第2个代码逻辑：根据原始数据，计算得到统计数据；
                    //这里也更适合做单元测试，rebuild2中会把这部分剥离到Aggregator
                    RequestStat requestStat = Aggregator.aggregate(requestInfosPerApi, durationInMillis);
                    stats.put(apiName, requestStat);
                }
                // 第3个代码逻辑：将统计数据显示到终端（命令行或邮件）；
                // rebuild2中会把这部分剥离到ConsoleViewer 类和 EmailViewer类
                System.out.println("Time Span: [" + startTimeInMillis + ", " + endTimeInMillis + "]");
                Gson gson = new Gson();
                System.out.println(gson.toJson(stats));
            }
        }, 0, periodInSeconds, TimeUnit.SECONDS);
    }
}



