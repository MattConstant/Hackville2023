package ca.sheridancollege.consmatt.services;


import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import ca.sheridancollege.consmatt.beans.BotRequest;
import ca.sheridancollege.consmatt.configuration.ChatGptConfig;
import ca.sheridancollege.consmatt.requests.ChatGptRequest;
import ca.sheridancollege.consmatt.requests.ChatGptResponse;

@Service
public class BotServiceImpl {

	private static RestTemplate restTemplate = new RestTemplate();
	
	public HttpEntity<ChatGptRequest> buildHttpEntity(ChatGptRequest chatRequest) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.parseMediaType(ChatGptConfig.MEDIA_TYPE));
		headers.add(ChatGptConfig.AUTHORIZATION, ChatGptConfig.BEARER + ChatGptConfig.API_KEY);
		return new HttpEntity<>(chatRequest, headers);
	}
	
	public ChatGptResponse getResponse(HttpEntity<ChatGptRequest> chatRequestHttpEntity) {
		
		ResponseEntity<ChatGptResponse> responseEntity = restTemplate.postForEntity(
				ChatGptConfig.URL,
				chatRequestHttpEntity,
				ChatGptResponse.class);
		
		return responseEntity.getBody();
	}
	
	public ChatGptResponse askQuestion(BotRequest botRequest) {
		return this.getResponse(
				this.buildHttpEntity(
					new ChatGptRequest(
							ChatGptConfig.MODEL,
							botRequest.getMessage(),
							ChatGptConfig.MAX_TOKEN,
							ChatGptConfig.TEMPERATURE,
							ChatGptConfig.TOP_P)));
	}
	
}
