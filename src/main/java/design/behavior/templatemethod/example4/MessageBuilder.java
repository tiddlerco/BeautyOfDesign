package design.behavior.templatemethod.example4;

/**
 * 泛型接口的使用
 *
 * @title: MessageBuilder
 * @Author yuke
 * @Date: 2022/5/6 8:14
 */
@FunctionalInterface
public interface MessageBuilder {


    String buildMessage(String str);
}
