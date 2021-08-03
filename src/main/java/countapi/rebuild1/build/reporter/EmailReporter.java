package countapi.rebuild1.build.reporter;

import countapi.rebuild1.build.Aggregator;
import countapi.rebuild1.build.stroage.MetricsStorage;
import countapi.rebuild1.entity.RequestInfo;
import countapi.rebuild1.entity.RequestStat;

import java.util.*;

/**
 * 以一定频率统计并发送统计数据到命令行和邮件
 * 存在问题：
 * 1.ConsoleReporter和EmailReporter 两个类中存在代码重复问题
 * 2.整个类负责的事情比较多，不相干的逻辑糅合在里面，职责不够单一。
 * 特别是显示部分的代码可能会比较复杂（比如 Email 的显示方式），
 * 最好能将这部分显示逻辑剥离出来，设计成一个独立的类
 *
 * @Author 喻可
 * @Date 2021/6/22 11:05
 */
public class EmailReporter {
    private static final Long DAY_HOURS_IN_SECONDS = 86400L;

    private MetricsStorage metricsStorage;
    private EmailSender emailSender;
    private List<String> toAddresses = new ArrayList<>();

    public EmailReporter(MetricsStorage metricsStorage) {
        this(metricsStorage, new EmailSender(/*省略参数*/));
    }

    public EmailReporter(MetricsStorage metricsStorage, EmailSender emailSender) {
        this.metricsStorage = metricsStorage;
        this.emailSender = emailSender;
    }

    public void addToAddress(String address) {
        toAddresses.add(address);
    }

    public void startDailyReport() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        Date firstTime = calendar.getTime();
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                long durationInMillis = DAY_HOURS_IN_SECONDS * 1000;
                long endTimeInMillis = System.currentTimeMillis();
                long startTimeInMillis = endTimeInMillis - durationInMillis;
                Map<String, List<RequestInfo>> requestInfos =
                        metricsStorage.getRequestInfos(startTimeInMillis, endTimeInMillis);
                Map<String, RequestStat> stats = new HashMap<>();
                for (Map.Entry<String, List<RequestInfo>> entry : requestInfos.entrySet()) {
                    String apiName = entry.getKey();
                    List<RequestInfo> requestInfosPerApi = entry.getValue();
                    RequestStat requestStat = Aggregator.aggregate(requestInfosPerApi, durationInMillis);
                    stats.put(apiName, requestStat);
                }
                // TODO: 格式化为html格式，并且发送邮件
            }
        }, firstTime, DAY_HOURS_IN_SECONDS * 1000);
    }
}