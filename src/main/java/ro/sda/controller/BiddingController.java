package ro.sda.controller;

import org.springframework.web.bind.annotation.*;
import ro.sda.dto.bidding.request.RequestBidding;
import ro.sda.service.AuctionSiteService;
@RestController
@RequestMapping("/auction")
public class BiddingController {

    private AuctionSiteService auctionSiteService;

    public BiddingController(AuctionSiteService auctionSiteService) {
        this.auctionSiteService = auctionSiteService;
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
