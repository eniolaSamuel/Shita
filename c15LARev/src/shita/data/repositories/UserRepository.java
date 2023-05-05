package shita.data.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import shita.data.models.User;

import java.util.List;


public interface UserRepository extends MongoRepository<User, String> {


}
