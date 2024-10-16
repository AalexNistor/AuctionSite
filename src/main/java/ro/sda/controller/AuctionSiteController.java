package ro.sda.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.sda.dto.bidding.request.RequestBidding;
import ro.sda.dto.request.auction.AuctionRequest;
import ro.sda.dto.request.user.AddRoleToUserRequest;
import ro.sda.dto.request.user.RoleRequest;
import ro.sda.dto.request.user.UserRequest;
import ro.sda.dto.response.auction.AuctionResponse;
import ro.sda.dto.response.user.RoleResponse;
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

    @PutMapping(path = "/user/edit")
    public void editUser(@RequestParam Long id, @RequestBody UserRequest editUser) {
        auctionSiteService.editUser(id, editUser);
    }

    @PostMapping(path = "/create")
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

    @PostMapping(path = "/role")
    public ResponseEntity<Void> addRole(@RequestBody RoleRequest roleRequest) {
        auctionSiteService.addRole(roleRequest);
        return ResponseEntity.ok().build();
    }

    @GetMapping(path = "/role/{id}")
    public ResponseEntity<RoleResponse> getRole(@PathVariable Integer id)
    {
        RoleResponse response = auctionSiteService.getRole(id);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/addRoleToUser")
    public ResponseEntity<Void> addRoleToUser(@RequestBody AddRoleToUserRequest addRoleToUserRequest)
    {

        auctionSiteService.addRoleToUser(addRoleToUserRequest);
        return ResponseEntity.ok().build();
    }
}
