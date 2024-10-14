package ro.sda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.sda.entity.Auction;
import ro.sda.enums.Category;

import java.util.List;
import java.util.Optional;

@Repository
public interface AuctionRepository extends JpaRepository<Auction, Long> {
    List<Auction> findByCategory(Category category);

    Optional<Auction> findByTitle(String title);
}
