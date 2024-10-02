package ro.sda.dto.request.user;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SingInRequest {

    @NotEmpty
    private String loginEmail;
    @NotEmpty
    private String password;


}
