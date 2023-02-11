package ca.sheridancollege.consmatt.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.consmatt.beans.Receiver;
@Repository
public interface ReceiveRepository extends MongoRepository<Receiver, String> {

}
