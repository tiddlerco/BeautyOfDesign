package work;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @Author 喻可
 * @Date 2021/11/12 17:52
 */
public class Learn {

    public void localDateTimeUse(){
        LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }
}
