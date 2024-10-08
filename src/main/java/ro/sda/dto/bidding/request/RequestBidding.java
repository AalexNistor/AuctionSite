package ro.sda.dto.bidding.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestBidding {

    private BigDecimal amount;
    private String accountName;
    private String title;
}
