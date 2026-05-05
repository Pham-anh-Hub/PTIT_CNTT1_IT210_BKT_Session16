package bkt_session16.ptit_cntt1_it210_bkt_session16.repository;

import bkt_session16.ptit_cntt1_it210_bkt_session16.model.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IWalletRepository extends JpaRepository<Wallet, Long> {

}
