package bkt_session16.ptit_cntt1_it210_bkt_session16.repository;

import bkt_session16.ptit_cntt1_it210_bkt_session16.model.TransactionHistory;
import bkt_session16.ptit_cntt1_it210_bkt_session16.model.Wallet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ITransactionHistoryRepository extends JpaRepository<TransactionHistory, Long> {

    Page<TransactionHistory> getTransactionHistoriesByWalletId(Wallet walletId, Pageable pageable);


    @Query("""
        select t from TransactionHistory t where t.transAmount > :targetAmount
        """)
    Page<TransactionHistory> findTransactionHistoriesThanTarget(Double targetAmount, Pageable pageable);
}
