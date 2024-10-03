package ro.sda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.sda.entity.Auction;
import ro.sda.enums.Category;

import java.util.List;

public interface AuctionRepository extends JpaRepository<Auction, Long> {
    List<Auction> findByCategory(Category category);
}
