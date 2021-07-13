package design.factory;

import design.factory.common.exception.InvalidRuleConfigException;
import design.factory.common.ruleconfig.configparser.IRuleConfigParser;
import design.factory.common.ruleconfig.RuleConfig;
import design.factory.common.ruleconfig.configparser.JsonRuleConfigParser;
import design.factory.common.ruleconfig.configparser.PropertiesRuleConfigParser;
import design.factory.common.ruleconfig.configparser.XmlRuleConfigParser;
import design.factory.common.ruleconfig.configparser.YamlRuleConfigParser;

/**
 * 未使用简单工厂的做法
 *
 * @Author 喻可
 * @Date 2021/7/7 15:43
 * <p>场景
 * 根据配置文件的后缀（json、xml、yaml、properties），
 * 选择不同的解析器（JsonRuleConfigParser、XmlRuleConfigParser……）
 * 将存储在文件中的配置解析成内存对象 RuleConfig。
 */

public class RuleConfigSource {


    public RuleConfig load(String ruleConfigFilePath) throws InvalidRuleConfigException {
        String ruleConfigFileExtension = getFileExtension(ruleConfigFilePath);
        IRuleConfigParser parser = createParser(ruleConfigFileExtension);

        if (parser == null) {
            throw new InvalidRuleConfigException(
                    "Rule config file format is not supported: " + ruleConfigFilePath);
        }

        String configText = "";
        //从ruleConfigFilePath文件中读取配置文本到configText中
        RuleConfig ruleConfig = parser.parse(configText);
        return ruleConfig;
    }

    private String getFileExtension(String filePath) {
        //...解析文件名获取扩展名，比如rule.json，返回json
        return "json";
    }

    private IRuleConfigParser createParser(String configFormat) {
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
