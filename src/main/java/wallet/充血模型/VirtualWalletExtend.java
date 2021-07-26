package wallet.充血模型;

import java.math.BigDecimal;

/**
 * @Author 喻可
 * @Date 2021/6/25 18:39
 */
//要支持透支一定额度和冻结部分余额的功能
public class VirtualWalletExtend {

    private Long id;
    private Long createTime = System.currentTimeMillis();
    private BigDecimal balance = BigDecimal.ZERO;
    //允许透支
    private boolean isAllowedOverdraft = true;
    //允许透支金额
    private BigDecimal overdraftAmount = BigDecimal.ZERO;
    //冻结资金
    private BigDecimal frozenAmount = BigDecimal.ZERO;

    public VirtualWalletExtend(Long preAllocatedId) {
        this.id = preAllocatedId;
    }

    public void freeze(BigDecimal amount) {
    }

    public void unfreeze(BigDecimal amount) {
    }

    public void increaseOverdraftAmount(BigDecimal amount) {
    }

    public void decreaseOverdraftAmount(BigDecimal amount) {
    }

    public void closeOverdraft() {
    }

    public void openOverdraft() {
    }

    public BigDecimal balance() {
        return this.balance;
    }

    public BigDecimal getAvaliableBalance() {
        BigDecimal totalAvaliableBalance = this.balance.subtract(this.frozenAmount);
        if (isAllowedOverdraft) {
            totalAvaliableBalance = totalAvaliableBalance.add(this.overdraftAmount);
        }
        return totalAvaliableBalance;
    }

    public void debit(BigDecimal amount) throws Exception {
        BigDecimal totalAvaliableBalance = getAvaliableBalance();
        if (totalAvaliableBalance.compareTo(amount) < 0) {
            throw new Exception("出账金额大于余额");
        }
        this.balance = this.balance.subtract(amount);
    }

    public void credit(BigDecimal amount) throws Exception {
        if (amount.compareTo(BigDecimal.ZERO) < 0) {
            throw new Exception("入账金额为负数");
        }
        this.balance = this.balance.add(amount);
    }
}
