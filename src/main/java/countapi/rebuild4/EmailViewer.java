package countapi.rebuild4;

import countapi.rebuild3.viewer.StatViewer;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author 喻可
 * @Date 2021/7/5 14:51
 */
//负责显示
public class EmailViewer implements StatViewer {
    private List<String> emailSender;
    private List toAddresses = new ArrayList<>();


    public EmailViewer(List<String> emailSender) {
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
