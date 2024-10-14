package ro.sda.service.security;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import ro.sda.dto.request.user.SignInRequest;
import ro.sda.dto.request.user.UserRequest;
import ro.sda.dto.response.user.SignInResponse;
import ro.sda.entity.Role;
import ro.sda.entity.UserAccount;
import ro.sda.mapper.UserMapper;
import ro.sda.repository.RoleRepository;
import ro.sda.repository.UserAccountRepository;

import java.util.Optional;

@Service
public class AuthService {

    private final UserAccountRepository userAccountRepository;
    private final RoleRepository roleRepository;
    private final AuthenticationManager authenticationManager;

    public AuthService(UserAccountRepository userAccountRepository, RoleRepository roleRepository, AuthenticationManager authenticationManager) {
        this.userAccountRepository = userAccountRepository;
        this.roleRepository = roleRepository;
        this.authenticationManager = authenticationManager;
    }

    public UserAccount getUserByEmail(String email) {
        Optional<UserAccount> optionalUser = userAccountRepository.findUserByEmail(email);

        if (optionalUser.isPresent()) {
            System.out.println("Email is already in use"); // Need to create an exception
        }
        return null;
    }

    public void registerUser(UserRequest userRequest) {
        UserAccount userAccount = UserMapper.fromUserRequestToEntity(userRequest);
        Optional<Role> optionalRole = roleRepository.findRoleByName(userRequest.getRole());
        if (optionalRole.isPresent()) {
            userAccount.addRole(optionalRole.get());
        } else {
            System.out.println("Role with name " + userRequest.getRole() + " is not in db");  // Need to create an exception
        }
        userAccountRepository.save(userAccount);
    }

    public SignInResponse signIn(SignInRequest signInRequest) {

        String email = signInRequest.getLoginEmail();
        String password = signInRequest.getPassword();

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        return UserMapper.fromUserDetailsImpl(userDetails);
    }
}
