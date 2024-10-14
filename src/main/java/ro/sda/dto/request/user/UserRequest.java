package ro.sda.dto.request.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {


    @Email
    @NotEmpty(message = "Email should not be empty")
    private String loginEmail;

    @NotEmpty(message = "Password should not be empty")
    private String password;

    @NotEmpty(message = "Account name should not be empty")
    private String accountName;

    @NotEmpty(message="House number should not be empty")
    private int houseNumber;

    @NotEmpty
    private int zipCode;

    @NotEmpty
    private String street;

    @NotEmpty
    private String role;


}