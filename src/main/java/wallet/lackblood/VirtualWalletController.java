package wallet.lackblood;

import wallet.fullblood.service.VirtualWalletService;

import java.math.BigDecimal;

/**
 * @Author 喻可
 * @Date 2021/6/25 18:28
 */

public class VirtualWalletController {
    // 通过构造函数或者IOC框架注入
    private VirtualWalletService virtualWalletService;

    //查询余额
    public BigDecimal getBalance(Long walletId) {
        return null;
    }

    //出账
    public void debit(Long walletId, BigDecimal amount) {
    }

    //入账
    public void credit(Long walletId, BigDecimal amount) {
    }

    //转账
    public void transfer(Long fromWalletId, Long toWalletId, BigDecimal amount) {
    }


}
