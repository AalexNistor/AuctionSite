package ro.sda.entity;

import jakarta.persistence.*;
import lombok.*;
import ro.sda.enums.Category;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "auction")
public class Auction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="title", nullable=false)
    private String title;

    @Column(name="description", nullable=false)
    private String description;

    @Column(name="category", nullable=false)
    @Enumerated(EnumType.STRING)
    private Category category;

    @Column(name="minimumAmount", nullable=false)
    private BigDecimal minimumAmount;

    @Column(name="location", nullable=false)
    private String location;

    @Column(name = "end_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "auction", orphanRemoval = true)
    private List<Bidding> bids;


}