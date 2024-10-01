package ro.sda.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "bidding")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bidding {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "auction_id", nullable = false)
    private Auction auction;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserAccount user;
    @Column(name = "amount", nullable = false)
    private BigDecimal amount;

}
