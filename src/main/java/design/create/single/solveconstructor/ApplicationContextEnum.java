package design.create.single.solveconstructor;

import alert.Alert;
import alert.AlertRule;
import alert.Notification;
import alert.handler.ErrorAlertHandler;
import alert.handler.TimeoutAlertHandler;
import alert.handler.TpsAlertHandler;

public enum ApplicationContextEnum {

    INSTANCE;

    private AlertRule alertRule;
    private Notification notification;
    private Alert alert;


    public void initializeBeans() {

        alertRule = new AlertRule(/*.省略参数.*/); //省略一些初始化代码
        notification = new Notification(/*.省略参数.*/); //省略一些初始化代码
        alert = new Alert();
        alert.addAlertHandler(new TpsAlertHandler(alertRule, notification));
        alert.addAlertHandler(new ErrorAlertHandler(alertRule, notification));
        alert.addAlertHandler(new TimeoutAlertHandler(alertRule, notification));
    }
    public Alert getAlert() {
        return alert;
    }

    ApplicationContextEnum() {
        initializeBeans();
    }
}
