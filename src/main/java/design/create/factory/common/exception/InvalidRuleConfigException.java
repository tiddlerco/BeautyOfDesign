package design.create.factory.common.exception;

/**
 * 对异常重新包装
 *
 * @Author 喻可
 * @Date 2021/7/7 15:59
 */
public class InvalidRuleConfigException extends Exception {

    public InvalidRuleConfigException(String message) {
        super(message);
    }
}
