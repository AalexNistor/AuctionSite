package ro.sda.dto;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ro.sda.entity.Auction;
import ro.sda.entity.UserAccount;

import java.math.BigDecimal;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BiddingDto {

    private Long id;
    private Auction auction;
    private UserAccount user;
    private BigDecimal amount;
}
