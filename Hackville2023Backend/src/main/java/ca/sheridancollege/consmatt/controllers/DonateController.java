package ca.sheridancollege.consmatt.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ca.sheridancollege.consmatt.beans.Donator;
import ca.sheridancollege.consmatt.beans.Receiver;
import ca.sheridancollege.consmatt.repositories.DonatorRepository;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/donate")
public class DonateController {

	private DonatorRepository donatorRepo;
	@GetMapping(value={"/", ""}) 
	public List<Donator> getDonatorCollection() {
	return donatorRepo.findAll();
}
	
	@PostMapping(value={"/", ""}, headers="Content-type=application/json")
	public String postDnatorCollection(@RequestBody Donator donator) {
		donator.setId(null);
		Donator d = donatorRepo.save(donator);
		return "Record was added at index" + d.getId();
	}
	
	
	
}
