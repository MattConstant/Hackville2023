package ca.sheridancollege.consmatt;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.consmatt.beans.Phone;

@Repository
public interface PhoneRepository extends MongoRepository<Phone, String>{

}
