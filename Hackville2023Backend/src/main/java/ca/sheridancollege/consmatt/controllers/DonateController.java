package ca.sheridancollege.consmatt.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ca.sheridancollege.consmatt.beans.BotRequest;
import ca.sheridancollege.consmatt.beans.Donator;
import ca.sheridancollege.consmatt.repositories.DonatorRepository;
import ca.sheridancollege.consmatt.services.BotServiceImpl;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/donate")
public class DonateController {

	private DonatorRepository donatorRepo;
	private BotServiceImpl botRequest;

	
	@CrossOrigin
	@GetMapping(value={"/", ""}) 
	public List<Donator> getDonatorCollection() {
	return donatorRepo.findAll();
}
	@CrossOrigin
	@PostMapping(value={"/", ""}, headers="Content-type=application/json")
	public String postDonatorCollection(@RequestBody Donator donator) {
		donator.setId(null);
		BotRequest br = new BotRequest();
		br.setMessage("Give instructions about " + donator.getTitle().toString());
	    donator.setInstructions(botRequest.askQuestion(br).toString());
		Donator d = donatorRepo.save(donator);
		return "Record was added at index" + d.getId();
	}
}