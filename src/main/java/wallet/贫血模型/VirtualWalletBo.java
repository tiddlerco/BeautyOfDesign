package wallet.贫血模型;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @Author 喻可
 * @Date 2021/6/25 18:28
 */

@Data
public class VirtualWalletBo {//省略getter/setter/constructor方法
    private Long id;
    private Long createTime;
    private BigDecimal balance;
}

