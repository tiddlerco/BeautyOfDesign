package alert;


import alert.handler.AlertHandler;

import java.util.ArrayList;
import java.util.List;


/**
 * 开闭原则中讲到
 * 桥接模式有拓展
 */
public class Alert {

    private List<AlertHandler> alertHandlers = new ArrayList<>();

    public void addAlertHandler(AlertHandler alertHandler) {
        this.alertHandlers.add(alertHandler);
    }

    public void check(ApiStatInfo apiStatInfo) {
        for (AlertHandler handler : alertHandlers) {
            handler.check(apiStatInfo);
        }
    }
}
