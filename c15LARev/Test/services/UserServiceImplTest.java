package services;

import shita.data.models.Event;
import shita.data.models.Package;
import shita.data.models.User;
import shita.dtos.requests.RegisterPackageRequest;
import shita.dtos.requests.RegisterUserRequest;
import shita.dtos.requests.UserFindPackageRequest;
import shita.dtos.requests.UserLogEventRequest;
import shita.dtos.responses.RegisterUserResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import shita.services.UserService;
import shita.services.UserServiceImpl;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceImplTest {
    private UserService userService;

    @BeforeEach
    public void  startWith(){
        userService = new UserServiceImpl();
        User newUser = new User();
    }

    @Test
    public void registerUserTest(){
        RegisterUserRequest registerUserRequest = new RegisterUserRequest();
        registerUserRequest.setFirstName("firstName");
        registerUserRequest.setLastName("lastName");
        registerUserRequest.setPhoneNumber("phoneNumber");
        registerUserRequest.setEmail("email");
        registerUserRequest.setAddress("address");
        RegisterUserResponse user = userService.registerNewUser(registerUserRequest);
        assertEquals(1,user.getId());
        User foundUser = userService.findUser(user.getId());
        assertEquals(user.getFullName(), foundUser.getFullName());
    }

    @Test
    public void userLogEventTest(){
        UserLogEventRequest userLogEventRequest = new UserLogEventRequest();
        User newUser = new User();
        userLogEventRequest.setWhat("Event Description");
        userLogEventRequest.setWho(newUser);
        userLogEventRequest.setWhen(LocalDateTime.now());
        Event event = userService.logEvent(userLogEventRequest);
        assertEquals(1, event.getId());
        Event foundEvent = userService.findEvent(event.getId());
        assertEquals(event, foundEvent);
    }

    @Test
    public void findPackageTest(){
        RegisterPackageRequest registerPackageRequest = new RegisterPackageRequest();
        UserFindPackageRequest userFindPackageRequest = new UserFindPackageRequest();
        User sendingUser = new User();
        User receivingUser = new User();
        registerPackageRequest.setSenderDetails(sendingUser);
        registerPackageRequest.setReceiverDetails(receivingUser);
        registerPackageRequest.setWeight(45.0);
        registerPackageRequest.setTimeStamp(LocalDateTime.now());
        registerPackageRequest.setPayOnDelivery(true);
        userFindPackageRequest.setId(userFindPackageRequest.getId());
        Package newPackage = userService.registerNewPackage(registerPackageRequest);
        Package foundPackage = userService.findPackage(userFindPackageRequest);
        assertEquals(1, newPackage.getId());
        assertEquals(newPackage, foundPackage);
        assertTrue(newPackage.isPayOnDelivery());
    }

   // @Test
   // public void deleteUserTest(){
       // RegisterUserRequest registerUserRequest = new RegisterUserRequest();
       // registerUserRequest.setFirstName("firstName");
        //registerUserRequest.setLastName("lastName");
        //registerUserRequest.setPhoneNumber("phoneNumber");
        //registerUserRequest.setEmail("email");
        //registerUserRequest.setAddress("address");
        //RegisterUserResponse user = userService.registerNewUser(registerUserRequest);
        //assertEquals(1, user.getId());
        //User deletedUser = userService.deleteUser();
    //}

}