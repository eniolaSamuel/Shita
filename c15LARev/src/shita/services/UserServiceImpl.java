package shita.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shita.data.models.Event;
import shita.data.models.Package;
import shita.data.models.User;
import shita.dtos.requests.RegisterPackageRequest;
import shita.dtos.requests.RegisterUserRequest;
import shita.dtos.requests.UserFindPackageRequest;
import shita.dtos.requests.UserLogEventRequest;
import shita.dtos.responses.RegisterPackageResponse;
import shita.dtos.responses.RegisterUserResponse;
import shita.data.repositories.*;
import shita.utils.Mapper;

import java.time.LocalDateTime;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PackageRepository packageRepository;
    @Autowired
    private EventRepository eventRepository;
    @Override
    public RegisterUserResponse registerNewUser(RegisterUserRequest registerUserRequest) {
        User newUser = Mapper.map(registerUserRequest);
        User savedUser = userRepository.save(newUser);
        return Mapper.map(savedUser);
    }
    @Override
    public RegisterPackageResponse registerNewPackage(RegisterPackageRequest registerPackageRequest) {
        Package newPackage = Mapper.map(registerPackageRequest);
        Package savedPackage = packageRepository.save(newPackage);
        return Mapper.map(savedPackage);
    }

    @Override
    public User findUser(String id) {
        var user = userRepository.findById(id);
        if (user.isEmpty())throw new IllegalArgumentException("User does not Exist");
        return userRepository.findById(id).get();
    }

    @Override
    public Package findPackage(UserFindPackageRequest userFindPackageRequest) {
        Package pa= packageService.findbyid(userFindPackageRequest);
        reponse = Mapper.map(pa)
        return packageRepository.findById(userFindPackageRequest.getId()).get();

    }



    @Override
    public Event logEvent(UserLogEventRequest logEventRequest) {
        Event newEvent = new Event();
        User newUser = new User();
        newEvent.setWhat("Event Description");
        newEvent.setWho(newUser);
        newEvent.setWhen(LocalDateTime.now());
        return eventRepository.save(newEvent);
    }

    @Override
    public Event findEvent(String id) {
        return eventRepository.findById(id).get();
    }


    @Override
    public String deleteUser(String id) {
        User foundUser = userRepository.findById(id).get();
        userRepository.delete(foundUser);
    }


}
