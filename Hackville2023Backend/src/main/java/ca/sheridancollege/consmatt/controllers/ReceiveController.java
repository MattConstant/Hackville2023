/**
 * 
 */
package ca.sheridancollege.consmatt.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ca.sheridancollege.consmatt.PhoneRepository;
import ca.sheridancollege.consmatt.beans.Phone;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/receive")
 class ReceiveController {

	private PhoneRepository phoneRepo;
	
	@GetMapping(value={"/", ""}) 
	public List<Phone> getPhoneCollection() {
	return phoneRepo.findAll();
}

}
