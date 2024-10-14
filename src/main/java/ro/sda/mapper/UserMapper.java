package ro.sda.mapper;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import ro.sda.dto.request.user.UserRequest;
import ro.sda.dto.response.user.SignInResponse;
import ro.sda.dto.response.user.UserResponse;
import ro.sda.entity.Role;
import ro.sda.entity.UserAccount;
import ro.sda.service.security.UserDetailsImpl;

import java.util.ArrayList;
import java.util.List;

public class UserMapper {

    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public static UserAccount fromUserRequestToEntity(UserRequest userRequest){

        UserAccount userAccount = new UserAccount();

        userAccount.setAccountName(userRequest.getAccountName());
        userAccount.setLoginEmail(userRequest.getLoginEmail());
        userAccount.setPassword(passwordEncoder.encode(userRequest.getPassword()));
        userAccount.setStreet(userRequest.getStreet());
        userAccount.setHouseNumber(userRequest.getHouseNumber());
        userAccount.setZipCode(userRequest.getZipCode());
        userAccount.setRoles(new ArrayList<>());

        return userAccount;
    }

    public static UserResponse fromEntityToResponse(UserAccount userAccount) {

        UserResponse userResponse = new UserResponse();

        userResponse.setAccountName(userAccount.getAccountName());
        userResponse.setLoginEmail(userAccount.getLoginEmail());
        userResponse.setStreet(userAccount.getStreet());
        userResponse.setHouseNumber(userAccount.getHouseNumber());
        userResponse.setZipCode(userAccount.getZipCode());

        if (!userAccount.getRoles().isEmpty()) {

            List<Role> roles = userAccount.getRoles();
            List<String> nameRoles = roles.stream().map(role -> role.getName()).toList();
            userResponse.setRoles(nameRoles);
        }

        return userResponse;
    }

    public static SignInResponse fromUserDetailsImpl(UserDetailsImpl userDetails) {
        SignInResponse response = new SignInResponse();

        response.setAccountName(userDetails.getUsername());
        response.setLoginEmail(userDetails.getEmail());
        List<String> roles = userDetails.getAuthorities().stream().map(a -> a.getAuthority()).toList();
        response.setRoles(roles);

        return response;
    }
}
