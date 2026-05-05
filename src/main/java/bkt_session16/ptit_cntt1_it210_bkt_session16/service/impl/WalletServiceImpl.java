package bkt_session16.ptit_cntt1_it210_bkt_session16.service.impl;

import bkt_session16.ptit_cntt1_it210_bkt_session16.model.Wallet;
import bkt_session16.ptit_cntt1_it210_bkt_session16.repository.ITransactionHistoryRepository;
import bkt_session16.ptit_cntt1_it210_bkt_session16.repository.IWalletRepository;
import bkt_session16.ptit_cntt1_it210_bkt_session16.service.IWalletService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class WalletServiceImpl implements IWalletService {

    private final IWalletRepository walletRepository;
    private final ITransactionHistoryRepository transactionHistoryRepository;


    @Override
    @Transactional
    public void transferMoney(Long fromWalletId, Long toWalletId, BigDecimal amount) {
        try{
            Wallet fromWallet = walletRepository.getReferenceById(fromWalletId);
            Wallet toWallet = walletRepository.getReferenceById(toWalletId);

            if (fromWallet.getBalance().compareTo(amount) <= 0){
                throw new RuntimeException("Số dư không đủ để thực hiện giao dịch");
            }

            fromWallet.setBalance(fromWallet.getBalance().subtract(amount));
            toWallet.setBalance(toWallet.getBalance().add(amount));

            walletRepository.saveAll(List.of(fromWallet, toWallet));
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }




    }

    @Override
    public void saveSystemLog(String message) {
        Propagation
    }
}
