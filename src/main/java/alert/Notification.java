package alert;

import alert.levelenum.NotificationEmergencyLevel;

/**
 * 告警通知类，支持邮件、短信、微信、手机等多种通知渠道
 */
public class Notification {

    public void notify(NotificationEmergencyLevel level, String s) {
        if (level.equals(NotificationEmergencyLevel.SEVERE)) {
            //...自动语音电话
        } else if (level.equals(NotificationEmergencyLevel.URGENCY)) {
            //...发微信
        } else if (level.equals(NotificationEmergencyLevel.NORMAL)) {
            //...发邮件
        } else if (level.equals(NotificationEmergencyLevel.TRIVIAL)) {
            //...发邮件
        }
    }
}

