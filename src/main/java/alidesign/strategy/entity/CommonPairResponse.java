package alidesign.strategy.entity;

/**
 * @title: CommonPairResponse
 * @Author yuke
 * @Date: 2021/10/29 8:05
 */
public class CommonPairResponse<T, R> {

    public  static <R> CommonPairResponse<String, R> success(String s, R r) {
        return null;
    }

    public static <R> CommonPairResponse<String, R> failure(String s) {
        return null;
    }
}
