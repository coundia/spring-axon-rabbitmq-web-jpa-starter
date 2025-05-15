package com.groupe2cs.bizyhub.shared.infrastructure.ia;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

import static com.groupe2cs.bizyhub.shared.infrastructure.ia.SystemPrompt.SYSTEM_PROMPT_V1;

@Slf4j
//@Service
@RequiredArgsConstructor
public class ChatGptService implements IAService {

	private final RestTemplate restTemplate = new RestTemplate();

	@Value("${openai.api.key:bad}")
	private String keyOpenAi;


	@Value("${openai.api.url:https://api.openai.com/v1/chat/completions}")
	private String urlOpenAi;

	public String generateResponse(String prompt) {

		log.info("[ChatGptService] Generating response for prompt: {}", prompt);
		try {

			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			headers.setBearerAuth(keyOpenAi);

			Map<String, Object> body = Map.of(
					"model", "gpt-3.5-turbo",
					"messages", List.of(
							Map.of("role", "system", "content", SYSTEM_PROMPT_V1),
							Map.of("role", "user", "content", prompt)
					)
			);

			HttpEntity<Map<String, Object>> request = new HttpEntity<>(body, headers);
			ResponseEntity<Map> response = restTemplate.postForEntity(urlOpenAi, request, Map.class);

			List<?> choices = (List<?>) response.getBody().get("choices");
			if (choices == null || choices.isEmpty()) {
				return "Aucune réponse générée.";
			}

			Map<?, ?> choice = (Map<?, ?>) choices.get(0);
			Map<?, ?> message = (Map<?, ?>) choice.get("message");
			return message.get("content").toString();

		} catch (Exception e) {
			log.error("❌ Failed to call ChatGPT: {}", e.getMessage(), e);
			return "Je suis désolé, je n’ai pas pu générer de réponse.";
		}
	}
}
