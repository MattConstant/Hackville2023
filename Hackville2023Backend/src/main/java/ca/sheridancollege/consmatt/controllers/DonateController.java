package ca.sheridancollege.consmatt.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ca.sheridancollege.consmatt.PhoneRepository;
import ca.sheridancollege.consmatt.beans.Phone;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/donate")
public class DonateController {

	private PhoneRepository phoneRepo;
	
	@PostMapping(value={"/", ""}, headers="Content-type=application/json")
	public String postPhoneCollection(@RequestBody Phone phone) {
		phone.setId(null);
		Phone p = phoneRepo.save(phone);
		return "Record was added at index" + p.getId();
	}
	
	
	
}
