package countapi.rebuild4易用性;

import countapi.rebuild1.entity.RequestInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author 喻可
 * @Date 2021/7/5 23:04
 */

public class PerfCounterTest {
    public static void main(String[] args) {
        //这里只通过无参构造就能完成所有的依赖对象
        ConsoleReporter consoleReporter = new ConsoleReporter();
        consoleReporter.startRepeatedReport(60, 60);

        List<String> emailToAddresses = new ArrayList<>();
        emailToAddresses.add("wangzheng@xzg.com");
        EmailReporter emailReporter = new EmailReporter(emailToAddresses);
        emailReporter.startDailyReport();

        MetricsCollector collector = new MetricsCollector();
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