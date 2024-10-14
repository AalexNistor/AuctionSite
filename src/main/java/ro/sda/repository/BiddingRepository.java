package ro.sda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.sda.entity.Bidding;

@Repository
public interface BiddingRepository extends JpaRepository<Bidding, Long> {
}
