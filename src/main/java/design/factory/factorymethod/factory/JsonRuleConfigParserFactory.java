package design.factory.factorymethod.factory;

import design.factory.ruleconfig.IRuleConfigParser;
import design.factory.ruleconfig.configparser.JsonRuleConfigParser;

/**
 * @Author 喻可
 * @Date 2021/7/7 16:44
 */
public class JsonRuleConfigParserFactory implements IRuleConfigParserFactory {
    @Override
    public IRuleConfigParser createParser() {
        return new JsonRuleConfigParser();
    }
}