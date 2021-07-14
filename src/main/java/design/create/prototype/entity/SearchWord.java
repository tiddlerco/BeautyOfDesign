package design.create.prototype.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author 喻可
 * @Date 2021/7/9 17:59
 */
@Data
@AllArgsConstructor
public class SearchWord {

    private long lastUpdateTime;

    private String keyWord;

    private long count;
}
