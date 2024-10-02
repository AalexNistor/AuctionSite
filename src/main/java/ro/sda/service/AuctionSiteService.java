package ro.sda.service;

import org.springframework.stereotype.Service;
import ro.sda.dto.request.user.UserRequest;
import ro.sda.entity.UserAccount;
import ro.sda.mapper.UserMapper;
import ro.sda.repository.AuctionRepository;
import ro.sda.repository.BiddingRepository;
import ro.sda.repository.UserAccountRepository;

@Service
public class AuctionSiteService {

    private AuctionRepository auctionRepository;
    private BiddingRepository biddingRepository;
    private UserAccountRepository userAccountRepository;

    public AuctionSiteService(AuctionRepository auctionRepository, BiddingRepository biddingRepository, UserAccountRepository userAccountRepository) {
        this.auctionRepository = auctionRepository;
        this.biddingRepository = biddingRepository;
        this.userAccountRepository = userAccountRepository;
    }

    public void createUser(UserRequest userRequest) {
        UserAccount userAccount = UserMapper.fromUserToRequest(userRequest);
        userAccountRepository.save(userAccount);
    }
}
