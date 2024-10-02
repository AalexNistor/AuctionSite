package ro.sda.mapper;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import ro.sda.dto.request.user.UserRequest;
import ro.sda.entity.UserAccount;

public class UserMapper {

//    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public static UserAccount fromUserToRequest(UserRequest userRequest){

        UserAccount userAccount = new UserAccount();

        userAccount.setAccountName(userRequest.getAccountName());
        userAccount.setLoginEmail(userRequest.getLoginEmail());
        userAccount.setPassword(userRequest.getPassword());
        userAccount.setStreet(userRequest.getStreet());
        userAccount.setHouseNumber(userRequest.getHouseNumber());
        userAccount.setZipCode(userRequest.getZipcode());

        return userAccount;
    }
}
