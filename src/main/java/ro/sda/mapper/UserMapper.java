package ro.sda.mapper;

import ro.sda.dto.request.user.UserRequest;
import ro.sda.dto.response.user.UserResponse;
import ro.sda.entity.UserAccount;

public class UserMapper {

//    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public static UserAccount fromUserRequestToEntity(UserRequest userRequest){

        UserAccount userAccount = new UserAccount();

        userAccount.setAccountName(userRequest.getAccountName());
        userAccount.setLoginEmail(userRequest.getLoginEmail());
        userAccount.setPassword(userRequest.getPassword());
        userAccount.setStreet(userRequest.getStreet());
        userAccount.setHouseNumber(userRequest.getHouseNumber());
        userAccount.setZipCode(userRequest.getZipcode());

        return userAccount;
    }

    public static UserResponse fromEntityToResponse(UserAccount userAccount) {

        UserResponse userResponse = new UserResponse();

        userResponse.setAccountName(userAccount.getAccountName());
        userResponse.setLoginEmail(userAccount.getLoginEmail());
        userResponse.setStreet(userAccount.getStreet());
        userResponse.setHouseNumber(userAccount.getHouseNumber());
        userResponse.setZipCode(userAccount.getZipCode());

        return userResponse;
    }
}
