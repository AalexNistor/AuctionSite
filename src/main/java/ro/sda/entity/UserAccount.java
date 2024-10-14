package ro.sda.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
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
    private int houseNumber;
    @Column(name = "zip_code")
    private int zipCode;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "users_roles",
               joinColumns = {@JoinColumn(name = "user_account_id")},
               inverseJoinColumns = {@JoinColumn(name = "role_id")})
    private List<Role> roles = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user", orphanRemoval = true)
    private List<Bidding> bids;

    public void addRole(Role role) {
        this.roles.add(role);
        role.getUsers().add(this);
    }



}