package work;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @Author 喻可
 * @Date 2021/11/12 17:52
 */
public class Learn {

    //当前时间转字符串
    public void localDateTimeUse() {
        LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    //double转string去除末尾的0
    private String convertDoubleToString(double val) {
        BigDecimal bd = new BigDecimal(String.valueOf(val));
        return bd.stripTrailingZeros().toPlainString();
    }
}
