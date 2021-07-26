package alert.handler;

import alert.AlertRule;
import alert.ApiStatInfo;
import alert.Notification;
import alert.levelenum.NotificationEmergencyLevel;

public class TimeoutAlertHandler extends AlertHandler{

    public TimeoutAlertHandler(AlertRule rule, Notification notification){
        super(rule, notification);
    }

    @Override
    public void check(ApiStatInfo apiStatInfo) {
        if(apiStatInfo.getTimeoutCount() > rule.getMatchedRule(apiStatInfo.getApi()).getMaxTimeout()) {
            notification.notify(NotificationEmergencyLevel.NORMAL, "...");
        }
    }
}
