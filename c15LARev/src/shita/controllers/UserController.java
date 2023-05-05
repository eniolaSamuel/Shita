package shita.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import shita.data.models.User;
import shita.dtos.requests.RegisterUserRequest;
import shita.dtos.responses.ApiResponse;
import shita.dtos.responses.RegisterUserResponse;
import org.springframework.web.bind.annotation.*;
import shita.services.UserService;
import shita.services.UserServiceImpl;

@RestController("/api")
public class UserController {
    @Autowired
    private UserService userService = new UserServiceImpl();

    @PostMapping("/user")
    public ResponseEntity<?> registerNewUser (@RequestBody RegisterUserRequest user){
        return new ResponseEntity<>(new ApiResponse(true, userService.registerNewUser(user)), HttpStatus.CREATED);}

    @GetMapping("/user/{id}")
    public ResponseEntity<?> findById (@PathVariable String id){
        try {
            return new ResponseEntity<>(new ApiResponse(true, userService.findUser(id)), HttpStatus.FOUND);
        }
        catch (IllegalArgumentException ex){
            return new ResponseEntity<>(new ApiResponse(false, ex.getMessage()), HttpStatus.NOT_FOUND);
        }
    }

}
