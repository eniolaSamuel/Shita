package shita.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class RegisterUserResponse {
    private String fullName;
    private String id;


}
