package countapi.rebuild3.reporter;

import countapi.rebuild3.Aggregator;
import countapi.rebuild3.stroge.MetricsStorage;
import countapi.rebuild3.viewer.StatViewer;

import java.util.*;

/**
 * @Author 喻可
 * @Date 2021/7/5 14:55
 */
//负责组装这三个类，将获取原始数据、聚合统计、显示统计结果到终端这三个阶段的工作串联起来，定时触发执行

public class EmailReporter extends ScheduledReporter {
    private static final Long DAY_HOURS_IN_SECONDS = 86400L;

    private MetricsStorage metricsStorage;
    private Aggregator aggregator;
    private StatViewer viewer;

    public EmailReporter(MetricsStorage metricsStorage, Aggregator aggregator, StatViewer viewer) {
        super(metricsStorage, aggregator, viewer);
    }


    public void startDailyReport() {
        Date firstTime = trimTimeFieldsToZeroOfNextDay();
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() { // 省略其他代码...
            }
        }, firstTime, DAY_HOURS_IN_SECONDS * 1000);
    }

    // 设置成protected而非private是为了方便写单元测试 可以使用测试工具
    protected Date trimTimeFieldsToZeroOfNextDay() {
        Calendar calendar = Calendar.getInstance(); // 这里可以获取当前时间
        calendar.add(Calendar.DATE, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }
}
