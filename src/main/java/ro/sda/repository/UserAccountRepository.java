package ro.sda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ro.sda.entity.UserAccount;

import java.util.Optional;

@Repository
public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {

//    @Query("SELECT FROM user_account" )
    Optional<UserAccount> findByAccountName(String accountName);
    Optional<UserAccount> findUserByEmail(String email);
}
