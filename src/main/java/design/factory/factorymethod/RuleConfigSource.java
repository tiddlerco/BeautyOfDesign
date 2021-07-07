package design.factory.factorymethod;

import design.factory.exception.InvalidRuleConfigException;
import design.factory.factorymethod.factory.*;
import design.factory.ruleconfig.IRuleConfigParser;
import design.factory.ruleconfig.RuleConfig;

/**
 * 工厂类对象的创建逻辑又耦合进了 load() 函数中，
 * 跟我们最初的代码版本非常相似，引入工厂方法非但没有解决问题，
 * 反倒让设计变得更加复杂了
 *
 * @Author 喻可
 * @Date 2021/7/7 16:54
 */

public class RuleConfigSource {
    public RuleConfig load(String ruleConfigFilePath) throws InvalidRuleConfigException {

        String ruleConfigFileExtension = getFileExtension(ruleConfigFilePath);

        IRuleConfigParserFactory parserFactory = createParserFactory(ruleConfigFileExtension);

        if (parserFactory == null) {
            throw new InvalidRuleConfigException(
                    "Rule config file format is not supported: " + ruleConfigFilePath);
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

    private IRuleConfigParserFactory createParserFactory(String ruleConfigFileExtension) {
        IRuleConfigParserFactory parserFactory = null;
        if ("json".equalsIgnoreCase(ruleConfigFileExtension)) {
            parserFactory = new JsonRuleConfigParserFactory();
        } else if ("xml".equalsIgnoreCase(ruleConfigFileExtension)) {
            parserFactory = new XmlRuleConfigParserFactory();
        } else if ("yaml".equalsIgnoreCase(ruleConfigFileExtension)) {
            parserFactory = new YamlRuleConfigParserFactory();
        } else if ("properties".equalsIgnoreCase(ruleConfigFileExtension)) {
            parserFactory = new PropertiesRuleConfigParserFactory();
        }
        return parserFactory;
    }

}
