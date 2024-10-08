package ro.sda.controller;

import org.springframework.web.bind.annotation.*;
import ro.sda.dto.bidding.request.RequestBidding;
import ro.sda.dto.request.user.AuctionRequest;
import ro.sda.dto.request.user.UserRequest;
import ro.sda.dto.response.user.AuctionResponse;
import ro.sda.dto.response.user.UserResponse;
import ro.sda.enums.Category;
import ro.sda.service.AuctionSiteService;

import java.util.List;

@RestController
@RequestMapping("/auction")
public class AuctionSiteController {
    private AuctionSiteService auctionSiteService;

    public AuctionSiteController(AuctionSiteService auctionSiteService) {
        this.auctionSiteService = auctionSiteService;
    }

    @PostMapping(path = "/user")
    public void addUser(@RequestBody UserRequest createUserRequest) {
        auctionSiteService.createUser(createUserRequest);
    }

    @PostMapping(path = "/auction")
    public void addAuction(@RequestBody AuctionRequest createAuctionRequest) {
        auctionSiteService.createAuction(createAuctionRequest);
    }

    @GetMapping("/auctions")
    public List<AuctionResponse> getAllAuctions(){
        return auctionSiteService.getAllAuctions();
    }

    @GetMapping("/category/{category}")
    public List<AuctionResponse> getAuctionsByCategory(@PathVariable Category category) {
        return auctionSiteService.getAuctionsByCategory(category);
    }

    @PostMapping(path = "/bidding")
    public void placeBid(@RequestBody RequestBidding placeBidding) {
        auctionSiteService.placeBidding(placeBidding);
    }

    @DeleteMapping("/delete/bidding/{id}")
    public void deleteBid(@PathVariable Long id){
        auctionSiteService.deleteBidding(id);
    }
}
