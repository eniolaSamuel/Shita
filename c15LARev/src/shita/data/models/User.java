package shita.data.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Document

public class User {

    @Id
    private String id;
    private String fullName;
    private String address;
    private String phoneNumber;
    private String email;


}
