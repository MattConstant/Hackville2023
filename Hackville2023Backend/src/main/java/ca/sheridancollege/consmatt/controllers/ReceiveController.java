/**
 * 
 */
package ca.sheridancollege.consmatt.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ca.sheridancollege.consmatt.beans.BotRequest;
import ca.sheridancollege.consmatt.beans.Receiver;
import ca.sheridancollege.consmatt.repositories.ReceiveRepository;
import ca.sheridancollege.consmatt.services.BotServiceImpl;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/receive")
 class ReceiveController {

	private ReceiveRepository receiveRepo;
	private BotServiceImpl botRequest;
	
	@CrossOrigin
	@GetMapping(value={"/", ""}) 
	public List<Receiver> getReceiverCollection() {
	return receiveRepo.findAll();
}
	@CrossOrigin
	@DeleteMapping("/{id}")
	public String deleteReceiver(@PathVariable String id) {
		Optional<Receiver> p = receiveRepo.findById(id);
		if(p.isPresent()) {
			receiveRepo.deleteById(id);
			return "Deleted";
			} else {
				return "Could not delete";
			}
	}
	@CrossOrigin
	@PostMapping(value={"/", ""}, headers="Content-type=application/json")
	public String postReceiverCollection(@RequestBody Receiver receiver) {
		receiver.setId(null);
		Receiver r = receiveRepo.save(receiver);
		BotRequest br = new BotRequest();
		br.setMessage("Give instructions about " + receiver.getPhoneRequested().toString());
		return "Record was added at index" + r.getId();	
	}
	
	
	
	

}
