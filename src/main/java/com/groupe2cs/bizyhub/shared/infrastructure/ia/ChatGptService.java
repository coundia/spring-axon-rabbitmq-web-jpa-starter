package com.groupe2cs.bizyhub.shared.infrastructure.ia;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.*;

import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class ChatGptService implements  IAService{

	private final RestTemplate restTemplate = new RestTemplate();

	@Value("${openai.api.key:bad}")
	private String keyOpenAi;

	@Value("${openai.api.systemPrompt:NA}")
	private String systemPrompt;

	public String generateResponse(String prompt) {
		try {
			String url = "https://api.openai.com/v1/chat/completions";
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			headers.setBearerAuth(keyOpenAi);

			Map<String, Object> body = Map.of(
					"model", "gpt-3.5-turbo",
					"messages", new Object[]{
							Map.of("role", "user", "content", prompt)
					}
			);

			HttpEntity<Map<String, Object>> request = new HttpEntity<>(body, headers);

			ResponseEntity<Map> response = restTemplate.postForEntity(url, request, Map.class);

			return ((Map<String, Object>) ((Map<String, Object>) ((java.util.List<?>) response.getBody().get("choices")).get(0)).get("message")).get("content").toString();

		} catch (Exception e) {
			log.error("❌ Failed to call ChatGPT: {}", e.getMessage());
			return "Je suis désolé, je n’ai pas pu générer de réponse.";
		}
	}
}
