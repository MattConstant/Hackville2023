package ca.sheridancollege.consmatt.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import ca.sheridancollege.consmatt.beans.Pet;

public interface PetRepository extends MongoRepository<Pet, String>{
	List<Pet> findAll();
}
