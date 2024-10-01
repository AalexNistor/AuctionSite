package ro.sda.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long id;
    private String loginEmail;
    private String password;
    private String accountName;
    private String street;
    private String houseNumber;
    private String zipCode;
}
