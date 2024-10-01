package ro.sda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.sda.entity.Bidding;

public interface BiddingRepository extends JpaRepository<Bidding, Long> {
}
