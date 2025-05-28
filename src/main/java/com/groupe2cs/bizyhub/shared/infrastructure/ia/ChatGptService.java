package com.groupe2cs.bizyhub.shared.infrastructure.ia;

import com.groupe2cs.bizyhub.categories.application.dto.CategoryRequest;
import com.groupe2cs.bizyhub.categories.application.usecase.CategoryCreateApplicationService;
import com.groupe2cs.bizyhub.categories.infrastructure.entity.Category;
import com.groupe2cs.bizyhub.categories.infrastructure.repository.CategoryRepository;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.Instant;
import java.util.List;
import java.util.Map;

import static com.groupe2cs.bizyhub.shared.infrastructure.ia.SystemPrompt.SYSTEM_PROMPT_V1;

@Slf4j
@Service
@Primary
@RequiredArgsConstructor
public class ChatGptService implements IAService {

	private final CategoryCreateApplicationService categoryCreateApplicationService;

	private final RestTemplate restTemplate = new RestTemplate();
	private final CategoryRepository categoryRepository;
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

	@Override
	public String getCategory(String type, String userId, String categoryName, String tenant) {
		log.info("getCategory");

		Category category = categoryRepository.findByNameAndCreatedById(categoryName, userId)
				.stream()
				.findFirst()
				.orElse(null)
				;

		if (category != null) {
			log.info("Category found: {}", category.getName());
			return category.getId();
		}

		log.info("Category not found, creating a new one");

		CategoryRequest categoryRequest = CategoryRequest
				.builder()
				.name(categoryName)
				.typeCategoryRaw(type)
				//.updatedAt(Instant.now())
				.isActive(true)
				.details("")
				//.reference("")
				.build();

		MetaRequest metaRequest = MetaRequest
				.builder()
				.userId(userId)
				.tenantId(tenant)
				.build();


		return categoryCreateApplicationService.createCategory(
				categoryRequest,
				metaRequest
		).getId();

	}

}
