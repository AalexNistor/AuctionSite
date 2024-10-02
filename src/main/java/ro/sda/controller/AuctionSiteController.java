package ro.sda.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.sda.dto.request.user.UserRequest;
import ro.sda.dto.response.user.UserResponse;
import ro.sda.service.AuctionSiteService;

@RestController
@RequestMapping("/auction")
public class AuctionSiteController {
    private AuctionSiteService auctionSiteService;

    public AuctionSiteController(AuctionSiteService auctionSiteService) {
        this.auctionSiteService = auctionSiteService;
    }

    @PostMapping
    public void addUser(@RequestBody UserRequest createUserRequest) {
        auctionSiteService.createUser(createUserRequest);
    }
}
