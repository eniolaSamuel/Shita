package shita.dtos.requests;

import lombok.Data;

@Data
public class RegisterUserRequest {
    private String firstName;
    private String lastName;
    private  String email;
    private  String phoneNumber;
    private  String address;

}
