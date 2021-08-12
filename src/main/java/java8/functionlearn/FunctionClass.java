package java8.functionlearn;

import java.util.function.Function;

/**
 * @Author 喻可
 * @Date 2021/8/12 11:02
 */
public class FunctionClass<T> {


    public String useFunction(String str, Function<String, String> method) {

        String result;

        result = str + method.apply("ykk");

        return result;
    }

    public String useFunction2(String str, Function<Integer, Integer> method) {

        String result;

        result = str + method.apply(20);

        return result;
    }

    public static <T> T getStr(T str) {

        return  str;
    }


    public static void main(String[] args) {

        FunctionClass functionClass = new FunctionClass();

        String result = functionClass.useFunction("my name is ", f -> getStr(f));

        String result2 = functionClass.useFunction2("my age is ", f -> getStr(f));


        System.out.println(result);

        System.out.println(result2);

    }

}
