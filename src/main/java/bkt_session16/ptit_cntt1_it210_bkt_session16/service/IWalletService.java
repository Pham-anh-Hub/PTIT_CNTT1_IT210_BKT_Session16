package bkt_session16.ptit_cntt1_it210_bkt_session16.service;

import java.math.BigDecimal;

public interface IWalletService {
    void transferMoney(Long fromWalletId, Long toWallet, BigDecimal amount);

    void saveSystemLog(String message);
}
