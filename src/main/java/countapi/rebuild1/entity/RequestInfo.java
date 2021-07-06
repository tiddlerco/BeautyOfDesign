package countapi.rebuild1.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author 喻可
 * @Date 2021/6/22 10:32
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestInfo {
    private String apiName;
    private double responseTime;
    private long timestamp;
    //...省略constructor/getter/setter方法...
}
