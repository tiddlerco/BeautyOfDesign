package design.create.factory.factorymethod.factory;

import design.create.factory.common.ruleconfig.configparser.IRuleConfigParser;
import design.create.factory.common.ruleconfig.configparser.XmlRuleConfigParser;

/**
 * @Author 喻可
 * @Date 2021/7/7 16:45
 */
public class XmlRuleConfigParserFactory implements IRuleConfigParserFactory {
    @Override
    public IRuleConfigParser createParser() {
        return new XmlRuleConfigParser();
    }
}
