//package wallet.充血模型;
//
//import java.math.BigDecimal;
//
///**
// * @Author 喻可
// * @Date 2021/6/25 18:39
// */
////要支持透支一定额度和冻结部分余额的功能
//public class VirtualWalletExtend {
//
//    private Long id;
//    private Long createTime = System.currentTimeMillis();
//    private BigDecimal balance = BigDecimal.ZERO;
//    private boolean isAllowedOverdraft = true;
//    private BigDecimal overdraftAmount = BigDecimal.ZERO;
//    private BigDecimal frozenAmount = BigDecimal.ZERO;
//
//    public VirtualWalletExtend(Long preAllocatedId) {
//        this.id = preAllocatedId;
//    }
//
//    public void freeze(BigDecimal amount) { ...}
//
//    public void unfreeze(BigDecimal amount) { ...}
//
//    public void increaseOverdraftAmount(BigDecimal amount) { ...}
//
//    public void decreaseOverdraftAmount(BigDecimal amount) { ...}
//
//    public void closeOverdraft() { ...}
//
//    public void openOverdraft() { ...}
//
//    public BigDecimal balance() {
//        return this.balance;
//    }
//
//    public BigDecimal getAvaliableBalance() {
//        BigDecimal totalAvaliableBalance = this.balance.subtract(this.frozenAmount);
//        if (isAllowedOverdraft) {
//            totalAvaliableBalance += this.overdraftAmount;
//        }
//        return totalAvaliableBalance;
//    }
//
//    public void debit(BigDecimal amount) {
//        BigDecimal totalAvaliableBalance = getAvaliableBalance();
//        if (totoalAvaliableBalance.compareTo(amount) < 0) {
//            throw new InsufficientBalanceException(...);
//        }
//        this.balance = this.balance.subtract(amount);
//    }
//
//    public void credit(BigDecimal amount) {
//        if (amount.compareTo(BigDecimal.ZERO) < 0) {
//            throw new InvalidAmountException(...);
//        }
//        this.balance = this.balance.add(amount);
//    }
//}
