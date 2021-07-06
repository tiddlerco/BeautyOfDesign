package countapi.rebuild1.build;

import countapi.rebuild1.build.reporter.ConsoleReporter;
import countapi.rebuild1.build.reporter.EmailReporter;
import countapi.rebuild1.build.stroage.MetricsStorage;
import countapi.rebuild1.build.stroage.RedisMetricsStorage;
import countapi.rebuild1.entity.RequestInfo;

/**
 * @Author 喻可
 * @Date 2021/6/22 10:27
 */

public class Demo {
    public static void main(String[] args) {
        MetricsStorage storage = new RedisMetricsStorage();
        ConsoleReporter consoleReporter = new ConsoleReporter(storage);
        consoleReporter.startRepeatedReport(60, 60);

        EmailReporter emailReporter = new EmailReporter(storage);
        emailReporter.addToAddress("wangzheng@xzg.com");
        emailReporter.startDailyReport();

        //采集接口请求的原始数据
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