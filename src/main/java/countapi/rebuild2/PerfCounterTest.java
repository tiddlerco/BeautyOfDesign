package countapi.rebuild2;

import countapi.rebuild1.entity.RequestInfo;
import countapi.rebuild2.reporter.ConsoleReporter;
import countapi.rebuild2.reporter.EmailReporter;
import countapi.rebuild2.storage.MetricsStorage;
import countapi.rebuild2.storage.RedisMetricsStorage;
import countapi.rebuild2.viewer.ConsoleViewer;
import countapi.rebuild2.viewer.EmailViewer;

/**
 * @Author 喻可
 * @Date 2021/7/5 15:01
 */

public class PerfCounterTest {
    public static void main(String[] args) {
        MetricsStorage storage = new RedisMetricsStorage();
        Aggregator aggregator = new Aggregator();

        // 定时触发统计并将结果显示到终端
        ConsoleViewer consoleViewer = new ConsoleViewer();
        ConsoleReporter consoleReporter = new ConsoleReporter(storage, aggregator, consoleViewer);
        consoleReporter.startRepeatedReport(60, 60);

        // 定时触发统计并将结果输出到邮件
        EmailViewer emailViewer = new EmailViewer();
        emailViewer.addToAddress("wangzheng@xzg.com");
        EmailReporter emailReporter = new EmailReporter(storage, aggregator, emailViewer);
        emailReporter.startDailyReport();

        // 收集接口访问数据
        MetricsCollector collector = new MetricsCollector(storage);
        collector.recordRequest(new RequestInfo("register", 123, 10234));
        collector.recordRequest(new RequestInfo("register", 223, 11234));
        collector.recordRequest(new RequestInfo("register", 323, 12334));
        collector.recordRequest(new RequestInfo("login", 23, 12434));
        collector.recordRequest(new RequestInfo("login", 1223, 14234));

        try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
