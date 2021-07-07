package design.factory.simplefactory;

import design.factory.ruleconfig.IRuleConfigParser;
import design.factory.ruleconfig.configparser.JsonRuleConfigParser;
import design.factory.ruleconfig.configparser.PropertiesRuleConfigParser;
import design.factory.ruleconfig.configparser.XmlRuleConfigParser;
import design.factory.ruleconfig.configparser.YamlRuleConfigParser;

/**
 * 简单工厂模式的第一种实现方法
 *
 * @Author 喻可
 * @Date 2021/7/7 16:18
 */
public class RuleConfigParserFactory1 {

    public static IRuleConfigParser createParser(String configFormat) {
        IRuleConfigParser parser = null;
        if ("json".equalsIgnoreCase(configFormat)) {
            parser = new JsonRuleConfigParser();
        } else if ("xml".equalsIgnoreCase(configFormat)) {
            parser = new XmlRuleConfigParser();
        } else if ("yaml".equalsIgnoreCase(configFormat)) {
            parser = new YamlRuleConfigParser();
        } else if ("properties".equalsIgnoreCase(configFormat)) {
            parser = new PropertiesRuleConfigParser();
        }
        return parser;
    }
}

