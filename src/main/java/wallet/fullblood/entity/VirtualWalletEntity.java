package wallet.fullblood.entity;

import java.math.BigDecimal;

/**
 * 用户虚拟钱包entity
 *
 * @Author 喻可
 * @Date 2021/7/26 9:23
 */
public class VirtualWalletEntity {
    private BigDecimal balance;

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
