package ro.sda.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.sda.dto.request.user.SignInRequest;
import ro.sda.dto.request.user.UserRequest;
import ro.sda.dto.response.user.SignInResponse;
import ro.sda.service.security.AuthService;

@RestController
@RequestMapping("/auction")
public class AuthController {

    private AuthService authService;
    private AuthenticationManager authenticationManager;

    public AuthController(AuthService authService, AuthenticationManager authenticationManager) {
        this.authService = authService;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/register")
    public ResponseEntity<Void> registerAdmin(@RequestBody UserRequest userRequest) {

        authService.getUserByEmail(userRequest.getLoginEmail());
        authService.registerUser(userRequest);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/signin")
    public ResponseEntity<SignInResponse> signIn(@RequestBody SignInRequest signInRequest) {
        SignInResponse response = authService.signIn(signInRequest);

        return ResponseEntity.ok().body(response);
    }


}
