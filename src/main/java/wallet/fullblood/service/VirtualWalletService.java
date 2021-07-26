package wallet.fullblood.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wallet.fullblood.enumtype.TransactionType;
import wallet.fullblood.VirtualWallet;
import wallet.fullblood.entity.VirtualWalletEntity;
import wallet.fullblood.entity.VirtualWalletTransactionEntity;
import wallet.fullblood.repository.VirtualWalletRepository;
import wallet.fullblood.repository.VirtualWalletTransactionRepository;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * 1.Service 类负责与 Repository 交流
 * 2.Service 类负责跨领域模型的业务聚合功能,
 * transfer() 转账函数会涉及两个钱包的操作，因此这部分业务逻辑无法放到 VirtualWallet 类中
 * 3.Service 类负责一些非功能性及与三方系统交互的工作,
 * 比如幂等、事务、发邮件、发消息、记录日志、调用其他系统的 RPC 接口等，都可以放到 Service 类中。
 *
 * @Author 喻可
 * @Date 2021/7/26 9:22
 */
@Service
public class VirtualWalletService {

    @Resource
    private VirtualWalletRepository walletRepo;

    @Resource
    private VirtualWalletTransactionRepository transactionRepo;

    public VirtualWallet getVirtualWallet(Long walletId) {
        VirtualWalletEntity walletEntity = walletRepo.getWalletEntity(walletId);
        VirtualWallet wallet = convert(walletEntity);
        return wallet;
    }

    public BigDecimal getBalance(Long walletId) {
        return walletRepo.getBalance(walletId);
    }

    //出账，用户账户扣钱，商家账户加钱
    @Transactional
    public void debit(Long walletId, BigDecimal amount) throws Exception {
        VirtualWalletEntity walletEntity = walletRepo.getWalletEntity(walletId);
        VirtualWallet wallet = convert(walletEntity);
        wallet.debit(amount);
        VirtualWalletTransactionEntity transactionEntity = new VirtualWalletTransactionEntity();
        transactionEntity.setAmount(amount);
        transactionEntity.setCreateTime(System.currentTimeMillis());
        transactionEntity.setType(TransactionType.DEBIT);
        transactionEntity.setFromWalletId(walletId);
        transactionRepo.saveTransaction(transactionEntity);
        walletRepo.updateBalance(walletId, wallet.balance());
    }

    //入账
    @Transactional
    public void credit(Long walletId, BigDecimal amount) throws Exception {
        VirtualWalletEntity walletEntity = walletRepo.getWalletEntity(walletId);
        VirtualWallet wallet = convert(walletEntity);
        wallet.credit(amount);
        VirtualWalletTransactionEntity transactionEntity = new VirtualWalletTransactionEntity();
        transactionEntity.setAmount(amount);
        transactionEntity.setCreateTime(System.currentTimeMillis());
        transactionEntity.setType(TransactionType.CREDIT);
        transactionEntity.setFromWalletId(walletId);
        transactionRepo.saveTransaction(transactionEntity);
        walletRepo.updateBalance(walletId, wallet.balance());
    }

    //转账
    @Transactional
    public void transfer(Long fromWalletId, Long toWalletId, BigDecimal amount) throws Exception {
        VirtualWalletTransactionEntity transactionEntity = new VirtualWalletTransactionEntity();
        transactionEntity.setAmount(amount);
        transactionEntity.setCreateTime(System.currentTimeMillis());
        transactionEntity.setType(TransactionType.TRANSFER);
        transactionEntity.setFromWalletId(fromWalletId);
        transactionEntity.setToWalletId(toWalletId);
        transactionRepo.saveTransaction(transactionEntity);
        debit(fromWalletId, amount);
        credit(toWalletId, amount);
    }


    private VirtualWallet convert(VirtualWalletEntity walletEntity) {
        return null;
    }
}
