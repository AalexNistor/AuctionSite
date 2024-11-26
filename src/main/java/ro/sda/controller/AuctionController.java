package ro.sda.controller;

import org.springframework.web.bind.annotation.*;
import ro.sda.dto.request.auction.AuctionRequest;
import ro.sda.dto.response.auction.AuctionResponse;
import ro.sda.enums.Category;
import ro.sda.service.AuctionSiteService;

import java.util.List;

@RestController
@RequestMapping("/auction")
public class AuctionController {

    private AuctionSiteService auctionSiteService;

    public AuctionController(AuctionSiteService auctionSiteService) {
        this.auctionSiteService = auctionSiteService;
    }

    @PostMapping(path = "/create")
    public void addAuction(@RequestBody AuctionRequest createAuctionRequest) {
        auctionSiteService.createAuction(createAuctionRequest);
    }

    @PutMapping(path = "/edit")
    public void editAuction(@RequestParam Long id, @RequestBody AuctionRequest editAuction) {
        auctionSiteService.editAuction(id, editAuction);
    }

    @GetMapping("/all")
    public List<AuctionResponse> getAllAuctions(){
        return auctionSiteService.getAllAuctions();
    }

    @GetMapping("/category/{category}")
    public List<AuctionResponse> getAuctionsByCategory(@PathVariable Category category) {
        return auctionSiteService.getAuctionsByCategory(category);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteAuction(@PathVariable Long id) {
        auctionSiteService.deleteAuction(id);
    }
}
