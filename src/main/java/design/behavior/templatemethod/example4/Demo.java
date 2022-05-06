package design.behavior.templatemethod.example4;

/**
 * @title: Demo
 * @Author yuke
 * @Date: 2022/5/6 8:18
 */
public class Demo {

    private static void log(int level, MessageBuilder builder) {
        if (level == 1) {
            System.out.println(builder.buildMessage("需要拼接字符"));
        }
    }

    public static void main(String[] args) {
        String msgA = "Hello";
        String msgB = "World";
        String msgC = "Java";
        log(1, msg -> msg + msgA + msgB + msgC);
    }
}
