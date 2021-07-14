package design.create.factory.common.ruleconfig.configparser;

import design.create.factory.common.ruleconfig.RuleConfig;

/**
 * @Author 喻可
 * @Date 2021/7/7 15:47
 */
public interface IRuleConfigParser {
    public RuleConfig parse(String configText);
}
