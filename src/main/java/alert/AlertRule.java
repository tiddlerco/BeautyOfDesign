package alert;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * AlertRule 存储告警规则.
 * 可以自由设置
 */
public class AlertRule {


    private static Map<String, RuleData> ruleDataMap = new HashMap<>();


    public RuleData getMatchedRule(String api) {
        return ruleDataMap.get(api);
    }

    @Data
    public static class RuleData {

        private int maxTimeout;

        private int maxTps;

        private int maxErrorCount;

    }

}
