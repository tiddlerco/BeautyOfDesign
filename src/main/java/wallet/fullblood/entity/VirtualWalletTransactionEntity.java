package wallet.fullblood.entity;

import wallet.fullblood.enumtype.TransactionType;

import java.math.BigDecimal;

/**
 * 虚拟钱包交易记录entity
 *
 * @Author 喻可
 * @Date 2021/7/26 9:24
 */
public class VirtualWalletTransactionEntity {
    private BigDecimal amount;
    private long createTime;
    private TransactionType type;
    private Long fromWalletId;
    private Long toWalletId;

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    public TransactionType getType() {
        return type;
    }

    public void setFromWalletId(Long fromWalletId) {
        this.fromWalletId = fromWalletId;
    }

    public Long getFromWalletId() {
        return fromWalletId;
    }

    public void setToWalletId(Long toWalletId) {
        this.toWalletId = toWalletId;
    }

    public Long getToWalletId() {
        return toWalletId;
    }
}
