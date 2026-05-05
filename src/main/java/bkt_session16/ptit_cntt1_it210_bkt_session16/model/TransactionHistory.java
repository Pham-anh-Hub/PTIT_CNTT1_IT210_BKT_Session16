package bkt_session16.ptit_cntt1_it210_bkt_session16.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "trans_history")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class TransactionHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transId;

    @Column(name = "transAmount")
    private BigDecimal transAmount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "walletId")
    private Wallet walletId;
}
