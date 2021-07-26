package wallet.充血模型.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wallet.充血模型.enumtype.TransactionType;
import wallet.充血模型.VirtualWallet;
import wallet.充血模型.entity.VirtualWalletEntity;
import wallet.充血模型.entity.VirtualWalletTransactionEntity;
import wallet.充血模型.repository.VirtualWalletRepository;
import wallet.充血模型.repository.VirtualWalletTransactionRepository;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
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
