package ro.sda.service;

import org.springframework.stereotype.Service;
import ro.sda.dto.request.user.AuctionRequest;
import ro.sda.dto.request.user.UserRequest;
import ro.sda.dto.response.user.AuctionResponse;
import ro.sda.entity.Auction;
import ro.sda.entity.UserAccount;
import ro.sda.enums.Category;
import ro.sda.mapper.AuctionMapper;
import ro.sda.mapper.UserMapper;
import ro.sda.repository.AuctionRepository;
import ro.sda.repository.BiddingRepository;
import ro.sda.repository.UserAccountRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuctionSiteService {

    private AuctionRepository auctionRepository;
    private BiddingRepository biddingRepository;
    private UserAccountRepository userAccountRepository;

    public AuctionSiteService(AuctionRepository auctionRepository, BiddingRepository biddingRepository,
                              UserAccountRepository userAccountRepository)
    {
        this.auctionRepository = auctionRepository;
        this.biddingRepository = biddingRepository;
        this.userAccountRepository = userAccountRepository;
    }

    public void createUser(UserRequest userRequest) {
        UserAccount userAccount = UserMapper.fromUserRequestToEntity(userRequest);
        userAccountRepository.save(userAccount);
    }

    public AuctionResponse createAuction(AuctionRequest auctionRequest) {
        Auction auction = AuctionMapper.toEntity(auctionRequest);
        auction = auctionRepository.save(auction);
        return AuctionMapper.toResponse(auction);
    }

    public List<AuctionResponse> getAllAuctions() {
        return auctionRepository.findAll().stream()
                .map(AuctionMapper::toResponse)
                .collect(Collectors.toList());
    }

    public List<AuctionResponse> getAuctionsByCategory(Category category) {
        List<Auction> auctions = auctionRepository.findByCategory(category);
        return auctions.stream()
                .map(AuctionMapper::toResponse)
                .collect(Collectors.toList());
    }

}
