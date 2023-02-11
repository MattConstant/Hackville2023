package ca.sheridancollege.consmatt.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ca.sheridancollege.consmatt.models.Pet;
import ca.sheridancollege.consmatt.repositories.PetRepository;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/pets")
@AllArgsConstructor
public class PetRestController {
	private PetRepository petRepo;
	
	@GetMapping()
	public List<Pet> getAllPets() {
		return petRepo.findAll();
	}
}
