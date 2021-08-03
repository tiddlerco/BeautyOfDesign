package countapi.rebuild3代码优化去重.viewer;

import countapi.rebuild1.build.reporter.EmailSender;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author 喻可
 * @Date 2021/7/5 14:51
 */
//负责显示
public class EmailViewer implements StatViewer {
    private EmailSender emailSender;
    private List toAddresses = new ArrayList<>();

    public EmailViewer() {
        this.emailSender = new EmailSender(/*省略参数*/);
    }

    public EmailViewer(EmailSender emailSender) {
        this.emailSender = emailSender;
    }

    public void addToAddress(String address) {
        toAddresses.add(address);
    }

    public void output(Map requestStats, long startTimeInMillis, long endTimeInMills) {
        // format the requestStats to HTML style.
        // send it to email toAddresses.
    }
}
