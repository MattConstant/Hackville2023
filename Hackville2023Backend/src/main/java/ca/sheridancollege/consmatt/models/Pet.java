package ca.sheridancollege.consmatt.models;

import java.time.LocalDateTime;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Pet {
	@Id
	String id;
	String name;
	@DateTimeFormat(iso=DateTimeFormat.ISO.DATE_TIME)
	LocalDateTime dateAdded;
}
