package ca.sheridancollege.consmatt.beans;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Document
@Builder
public class Receiver {
	@Id
	private String id;
	private String phoneRequested;
	private String name;
	private String phoneNumber;
	private String address;
	
}
