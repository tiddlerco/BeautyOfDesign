package wallet.充血模型.repository;

import org.springframework.stereotype.Repository;
import wallet.充血模型.entity.VirtualWalletEntity;

import java.math.BigDecimal;

/**
 * 用户虚拟钱包
 *
 * @Author 喻可
 * @Date 2021/7/26 9:23
 */
@Repository
public class VirtualWalletRepository {
    public VirtualWalletEntity getWalletEntity(Long walletId) {
        return null;
    }

    public BigDecimal getBalance(Long walletId) {
        return null;
    }

    public void updateBalance(Long walletId, BigDecimal balance) {

    }
}
