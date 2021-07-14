package design.create.factory.factorymethod.factory;

import design.create.factory.common.ruleconfig.configparser.IRuleConfigParser;

/**
 * 使用多态将简单工厂第一种实现方式的 if 分支逻辑去掉
 * 是对工厂的多态
 * 当我们新增一种 parser 的时候，只需要新增一个实现了 IRuleConfigParserFactory 接口的 Factory 类即可
 *
 * @Author 喻可
 * @Date 2021/7/7 16:42
 */

public interface IRuleConfigParserFactory {

    IRuleConfigParser createParser();
}








