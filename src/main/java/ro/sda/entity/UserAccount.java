package ro.sda.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user_account")
public class UserAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "login_email", nullable = false, unique = true)
    private String loginEmail;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "account_name", nullable = false)
    private String accountName;
    @Column(name = "street")
    private String street;
    @Column(name = "house_number")
    private String houseNumber;
    @Column(name = "zip_code")
    private String zipCode;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user", orphanRemoval = true)
    private List<Bidding> bids;



}