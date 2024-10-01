package ro.sda.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuctionDto {

    private Long id;
    private String title;
    private String description;
    private String category;
    private BigDecimal minimumAmount;
    private String location;
    private Date endDate;
}
