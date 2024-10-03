package ro.sda.dto.response.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {

    private String accountName;
    private String loginEmail;
    private String street;
    private int houseNumber;
    private int zipCode;

}
