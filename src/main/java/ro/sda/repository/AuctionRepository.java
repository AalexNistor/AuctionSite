package ro.sda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.sda.entity.Auction;

public interface AuctionRepository extends JpaRepository<Auction, Long> {
}
