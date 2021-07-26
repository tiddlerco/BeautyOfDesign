package wallet.fullblood;

import java.math.BigDecimal;

/**
 * @Author 喻可
 * @Date 2021/6/25 18:36
 */
//将原来在 Service 类中的部分业务逻辑移动到 VirtualWallet 类中，
// 让 Service 类的实现依赖 VirtualWallet 类
public class VirtualWallet { // Domain领域模型(充血模型)

    private Long id;
    private Long createTime = System.currentTimeMillis();;
    private BigDecimal balance = BigDecimal.ZERO;

    public VirtualWallet(Long preAllocatedId) {
        this.id = preAllocatedId;
    }

    public BigDecimal balance() {
        return this.balance;
    }

    //出账
    public void debit(BigDecimal amount) throws Exception {
        if (this.balance.compareTo(amount) < 0) {
            throw new Exception("出账金额大于余额");
        }
        this.balance = this.balance.subtract(amount);
    }

    //入账
    public void credit(BigDecimal amount) throws Exception {
        if (amount.compareTo(BigDecimal.ZERO) < 0) {
            throw new Exception("入账金额为负数");
        }
        this.balance = this.balance.add(amount);
    }
}


