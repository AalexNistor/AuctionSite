package ro.sda.dto.request.auction;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ro.sda.enums.Category;

import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuctionRequest {
    private String title;
    private String description;

    private Category category;

    private BigDecimal minimumAmount;

    private String location;

    private Date endDate;
}
