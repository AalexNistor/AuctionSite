package ro.sda.dto.bidding.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseBidding {

    private BigDecimal amount;
    private String accountName;
    private String title;
}
