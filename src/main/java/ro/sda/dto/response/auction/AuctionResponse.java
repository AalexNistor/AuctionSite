package ro.sda.dto.response.auction;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ro.sda.entity.Bidding;
import ro.sda.enums.Category;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuctionResponse {

    private String title;
    private String description;
    private Category category;
    private BigDecimal minimumAmount;
    private String location;
    private Date endDate;

    private List<Bidding> bids;

}