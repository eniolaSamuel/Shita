package shita.utils;

import shita.data.models.Package;
import shita.data.models.User;
import shita.dtos.requests.RegisterPackageRequest;
import shita.dtos.requests.RegisterUserRequest;
import shita.dtos.responses.RegisterPackageResponse;
import shita.dtos.responses.RegisterUserResponse;

public class Mapper {
    public static User map(RegisterUserRequest registerUserRequest) {
        User newUser = new User();
        newUser.setFullName(registerUserRequest.getFirstName() + " " + registerUserRequest.getLastName());
        newUser.setPhoneNumber(registerUserRequest.getPhoneNumber());
        newUser.setEmail(registerUserRequest.getEmail());
        newUser.setAddress(registerUserRequest.getAddress());
        return newUser;
    }
    public static Package map(RegisterPackageRequest registerPackageRequest) {
        User newUser = new User();
        Package newPackage = new Package();
        newPackage.setSenderDetails(registerPackageRequest.getSenderName() + " " + registerPackageRequest.getSenderAddress() + " " + registerPackageRequest.getSenderPhoneNumber());
        newPackage.setReceiverDetails(registerPackageRequest.getReceiverName() + " " + registerPackageRequest.getReceiverAddress() + " " + registerPackageRequest.getReceiverPhoneNumber());
        newPackage.setWeight(registerPackageRequest.getWeight());
        newPackage.setTimeStamp(registerPackageRequest.getTimeStamp());
        newPackage.setPayOnDelivery(registerPackageRequest.isPayOnDelivery());
        return newPackage;
    }
    public static RegisterUserResponse map (User savedUser){
        RegisterUserResponse registerUserResponse = new RegisterUserResponse();
        registerUserResponse.setFullName(savedUser.getFullName());
        registerUserResponse.setId(savedUser.getId());
        return registerUserResponse;
    }
    public static RegisterPackageResponse map(Package savedPackage) {
        RegisterPackageResponse registerPackageResponse = new RegisterPackageResponse();
        registerPackageResponse.setSenderDetails(savedPackage.getSenderDetails());
        registerPackageResponse.setReceiverDetails(savedPackage.getReceiverDetails());
        registerPackageResponse.setDeliveryDay(savedPackage.getTimeStamp().toLocalDate());
        registerPackageResponse.setPayOnDelivery(savedPackage.isPayOnDelivery());
        return registerPackageResponse;
    }



}
