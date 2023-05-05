package shita.services;

import shita.data.models.Event;
import shita.data.models.Package;
import shita.data.models.User;
import shita.dtos.requests.RegisterPackageRequest;
import shita.dtos.requests.RegisterUserRequest;
import shita.dtos.requests.UserFindPackageRequest;
import shita.dtos.requests.UserLogEventRequest;
import shita.dtos.responses.RegisterPackageResponse;
import shita.dtos.responses.RegisterUserResponse;

public interface UserService {
    RegisterUserResponse registerNewUser (RegisterUserRequest regUserRequest);
    User findUser (String id);
    Package findPackage (UserFindPackageRequest userFindPackageRequest);
    RegisterPackageResponse registerNewPackage(RegisterPackageRequest registerPackageRequest);
    Event logEvent (UserLogEventRequest logEventRequest);
    Event findEvent (String id);
    String deleteUser (String id);
}
