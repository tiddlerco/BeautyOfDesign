package design.factory.simplefactory;

import design.factory.ruleconfig.IRuleConfigParser;
import design.factory.ruleconfig.configparser.JsonRuleConfigParser;
import design.factory.ruleconfig.configparser.PropertiesRuleConfigParser;
import design.factory.ruleconfig.configparser.XmlRuleConfigParser;
import design.factory.ruleconfig.configparser.YamlRuleConfigParser;

import java.util.HashMap;
import java.util.Map;

/**
 * 简单工厂模式的第二种实现方法
 * 引入内存缓存的概念
 *
 * @Author 喻可
 * @Date 2021/7/7 16:25
 */

public class RuleConfigParserFactory2 {

    private static final Map<String, IRuleConfigParser> cachedParsers = new HashMap<>();

    static {
        cachedParsers.put("json", new JsonRuleConfigParser());
        cachedParsers.put("xml", new XmlRuleConfigParser());
        cachedParsers.put("yaml", new YamlRuleConfigParser());
        cachedParsers.put("properties", new PropertiesRuleConfigParser());
    }

    public static IRuleConfigParser createParser(String configFormat) {
        if (configFormat == null || configFormat.isEmpty()) {
            return null;//返回null还是IllegalArgumentException全凭你自己说了算
        }
        IRuleConfigParser parser = cachedParsers.get(configFormat.toLowerCase());
        return parser;
    }
}
