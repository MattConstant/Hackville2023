package ca.sheridancollege.consmatt.bootstrap;

import java.time.LocalDateTime;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import ca.sheridancollege.consmatt.beans.Pet;
import ca.sheridancollege.consmatt.repositories.PetRepository;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class PetBootstrapData implements CommandLineRunner {
	private PetRepository petRepo;
	
	@Override
	public void run(String... args) throws Exception {
		petRepo.save(Pet.builder().name("Little shit").dateAdded(LocalDateTime.now()).build());
		
	}

}
