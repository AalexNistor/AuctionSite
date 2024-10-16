package ro.sda.service;

import org.springframework.stereotype.Service;
import ro.sda.dto.bidding.request.RequestBidding;
import ro.sda.dto.request.auction.AuctionRequest;
import ro.sda.dto.request.user.AddRoleToUserRequest;
import ro.sda.dto.request.user.RoleRequest;
import ro.sda.dto.request.user.UserRequest;
import ro.sda.dto.response.auction.AuctionResponse;
import ro.sda.dto.response.user.RoleResponse;
import ro.sda.entity.Auction;
import ro.sda.entity.Bidding;
import ro.sda.entity.Role;
import ro.sda.entity.UserAccount;
import ro.sda.enums.Category;
import ro.sda.exception.role.RoleNotFoundException;
import ro.sda.mapper.AuctionMapper;
import ro.sda.mapper.RoleMapper;
import ro.sda.mapper.UserMapper;
import ro.sda.repository.AuctionRepository;
import ro.sda.repository.BiddingRepository;
import ro.sda.repository.RoleRepository;
import ro.sda.repository.UserAccountRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AuctionSiteService {

    private AuctionRepository auctionRepository;
    private BiddingRepository biddingRepository;
    private UserAccountRepository userAccountRepository;
    private RoleRepository roleRepository;

    public AuctionSiteService(AuctionRepository auctionRepository, BiddingRepository biddingRepository,
                              UserAccountRepository userAccountRepository, RoleRepository roleRepository) {
        this.auctionRepository = auctionRepository;
        this.biddingRepository = biddingRepository;
        this.userAccountRepository = userAccountRepository;
        this.roleRepository = roleRepository;
    }

    public void createUser(UserRequest userRequest) {
        UserAccount userAccount = UserMapper.fromUserRequestToEntity(userRequest);
        userAccountRepository.save(userAccount);
    }

    public void editUser(Long id, UserRequest user) {
        Optional<UserAccount> optionalUser = userAccountRepository.findById(id);

        UserAccount userUpdated = optionalUser.get();
        userUpdated.setAccountName(user.getAccountName());
        userUpdated.setStreet(user.getStreet());
        userUpdated.setHouseNumber(user.getHouseNumber());
        userUpdated.setZipCode(user.getZipCode());

        userAccountRepository.save(userUpdated);
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

    public void placeBidding(RequestBidding requestBidding) {

        Optional<UserAccount> userAccount = userAccountRepository.findByAccountName(requestBidding.getAccountName());
        Optional<Auction> auction = auctionRepository.findByTitle(requestBidding.getTitle());

        Bidding bidding = new Bidding();
        bidding.setAmount(requestBidding.getAmount());
        bidding.setAuction(auction.get());
        bidding.setUser(userAccount.get());

        biddingRepository.save(bidding);
    }

    public void deleteBidding(Long id) {
        biddingRepository.deleteById(id);
    }

    public void addRole(RoleRequest roleRequest) {
        Role role = RoleMapper.fromRoleRequestToEntity(roleRequest);
        roleRepository.save(role);
    }

    public RoleResponse getRole(Integer id) {

        Optional<Role> optionalRole = roleRepository.findById(id);

        if (optionalRole.isPresent()) {
            Role role = optionalRole.get();
            return RoleMapper.fromRole(role);
        } else {
            throw new RoleNotFoundException("Role with id " + id + " not found");
        }
    }

    public void addRoleToUser(AddRoleToUserRequest addRoleToUserRequest) {

        String accountName = addRoleToUserRequest.getAccountName();
        String roleName = addRoleToUserRequest.getRoleName();

        Optional<UserAccount> optionalUser = userAccountRepository.findByAccountName(accountName);
        Optional<Role> optionalRole = roleRepository.findRoleByName(roleName);

        if (optionalUser.isPresent() && optionalRole.isPresent()) {

            UserAccount userAccount = optionalUser.get();
            Role role = optionalRole.get();

            userAccount.addRole(role);
            userAccountRepository.save(userAccount);
        }
    }

}
