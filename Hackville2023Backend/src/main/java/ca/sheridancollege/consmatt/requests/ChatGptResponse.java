package ca.sheridancollege.consmatt.requests;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import ca.sheridancollege.consmatt.beans.Choice;
import lombok.Data;
@Data
public class ChatGptResponse implements Serializable {
	private String id;
	private String object;
	private LocalDate created;
	private String model;
	private List<Choice> choices;
}
