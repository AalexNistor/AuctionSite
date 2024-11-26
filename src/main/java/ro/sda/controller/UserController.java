package ro.sda.controller;

import org.springframework.web.bind.annotation.*;
import ro.sda.dto.request.user.UserRequest;
import ro.sda.service.AuctionSiteService;

@RestController
@RequestMapping("/user")
public class UserController {

    private AuctionSiteService auctionSiteService;

    public UserController(AuctionSiteService auctionSiteService) {
        this.auctionSiteService = auctionSiteService;
    }

    @PostMapping(path = "/create")
    public void addUser(@RequestBody UserRequest createUserRequest) {
        auctionSiteService.createUser(createUserRequest);
    }

    @PutMapping(path = "/edit")
    public void editUser(@RequestParam Long id, @RequestBody UserRequest editUser) {
        auctionSiteService.editUser(id, editUser);
    }

    @GetMapping(path = "/{id}")
    public void getUser(@PathVariable Long id){
        auctionSiteService.getUser(id);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteUser(@PathVariable Long id){
        auctionSiteService.deleteUser(id);
    }
}
