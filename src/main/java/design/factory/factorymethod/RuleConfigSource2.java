package design.factory.factorymethod;

import design.factory.common.exception.InvalidRuleConfigException;
import design.factory.factorymethod.factory.*;
import design.factory.common.ruleconfig.configparser.IRuleConfigParser;
import design.factory.common.ruleconfig.RuleConfig;


/**
 * 为工厂类再创建一个简单工厂，也就是工厂的工厂，用来创建工厂类对象
 *
 * @Author 喻可
 * @Date 2021/7/7 16:59
 */

public class RuleConfigSource2 {
    public RuleConfig load(String ruleConfigFilePath) throws InvalidRuleConfigException {
        String ruleConfigFileExtension = getFileExtension(ruleConfigFilePath);

        IRuleConfigParserFactory parserFactory = RuleConfigParserFactoryMap.getParserFactory(ruleConfigFileExtension);
        if (parserFactory == null) {
            throw new InvalidRuleConfigException("Rule config file format is not supported: " + ruleConfigFilePath);
        }
        IRuleConfigParser parser = parserFactory.createParser();

        String configText = "";
        //从ruleConfigFilePath文件中读取配置文本到configText中
        RuleConfig ruleConfig = parser.parse(configText);
        return ruleConfig;
    }

    private String getFileExtension(String filePath) {
        //...解析文件名获取扩展名，比如rule.json，返回json
        return "json";
    }
}

