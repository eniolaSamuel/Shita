package shita.data.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import shita.data.models.Event;

import java.util.List;

public interface EventRepository extends MongoRepository<Event, String> {

}
