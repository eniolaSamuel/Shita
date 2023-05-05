package shita.data.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import shita.data.models.Package;

import java.util.List;

public interface PackageRepository extends MongoRepository<Package, String> {

}
