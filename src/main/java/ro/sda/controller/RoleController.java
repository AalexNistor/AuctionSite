package ro.sda.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.sda.dto.request.user.AddRoleToUserRequest;
import ro.sda.dto.request.user.RoleRequest;
import ro.sda.dto.response.user.RoleResponse;
import ro.sda.service.AuctionSiteService;

@RestController
@RequestMapping("/role")
public class RoleController {

    private AuctionSiteService auctionSiteService;

    public RoleController(AuctionSiteService auctionSiteService) {
        this.auctionSiteService = auctionSiteService;
    }

    @PostMapping(path = "/create")
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
