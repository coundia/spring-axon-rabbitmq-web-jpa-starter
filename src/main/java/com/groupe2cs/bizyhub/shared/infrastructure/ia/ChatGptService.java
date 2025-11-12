// File: src/main/java/com/groupe2cs/bizyhub/shared/infrastructure/ia/ChatGptService.java
// ChatGPT client with robust logging, HTTP interceptor, and category resolution fallback.

package com.groupe2cs.bizyhub.shared.infrastructure.ia;

import com.groupe2cs.bizyhub.categories.application.dto.CategoryRequest;
import com.groupe2cs.bizyhub.categories.application.usecase.CategoryCreateApplicationService;
import com.groupe2cs.bizyhub.categories.infrastructure.entity.Category;
import com.groupe2cs.bizyhub.categories.infrastructure.repository.CategoryRepository;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.http.*;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import java.util.UUID;


@Slf4j
@Service
@Primary
@RequiredArgsConstructor
public class ChatGptService implements IAService {

	private final CategoryCreateApplicationService categoryCreateApplicationService;
	private final CategoryRepository categoryRepository;

	// RestTemplate dédié à ce service pour éviter de polluer une config globale
	private final RestTemplate restTemplate = new RestTemplate();

	@Value("${openai.api.key:bad}")
	private String keyOpenAi;

	@Value("${openai.api.url:https://api.openai.com/v1/chat/completions}")
	private String urlOpenAi;

	// Modèle configurable (ex: gpt-4o-mini / gpt-4o / gpt-3.5-turbo)
	@Value("${openai.api.model:gpt-3.5-turbo}")
	private String openAiModel;

	// Pour limiter la verbosité (en caractères) dans les logs
	@Value("${openai.log.maxPreview:200}")
	private int maxPreviewChars;

	private static String preview(@Nullable String v, int max) {
		if (v == null) return "null";
		String s = v.replace("\n", " ").replace("\r", " ");
		return s.length() > max ? s.substring(0, max) + "…" : s;
	}

	private static String safe(@Nullable String v) {
		if (v == null) return "null";
		return v.length() > 128 ? v.substring(0, 128) + "…" : v;
	}

	@PostConstruct
	void init() {
		// Interceptor pour tracer toutes les requêtes/réponses sortantes vers OpenAI
		restTemplate.getInterceptors().add((request, body, execution) -> {
			final long t0 = System.currentTimeMillis();
			final String bodyPreview = preview(new String(body, StandardCharsets.UTF_8), maxPreviewChars);
			try {
				log.info("[ChatGptService] -> {} {} headers={} bodyPreview={}",
						request.getMethod(), request.getURI(), request.getHeaders(), bodyPreview);

				ClientHttpResponse resp = execution.execute(request, body);

				// Bufferisation simple de la réponse pour log + réexposition
				byte[] bytes;
				try (InputStream is = resp.getBody()) {
					bytes = is.readAllBytes();
				}
				long dt = System.currentTimeMillis() - t0;
				String respPreview = preview(new String(bytes, StandardCharsets.UTF_8), maxPreviewChars);

				log.info("[ChatGptService] <- {} {} status={} dtMs={} bodyPreview={}",
						request.getMethod(), request.getURI(), resp.getStatusCode(), dt, respPreview);

				return new BufferingClientHttpResponse(resp, bytes);
			} catch (Exception e) {
				long dt = System.currentTimeMillis() - t0;
				log.error("[ChatGptService] !! {} {} failed dtMs={} err={}",
						request.getMethod(), request.getURI(), dt, e.toString(), e);
				throw e;
			}
		});

		if (keyOpenAi == null || keyOpenAi.isBlank() || "bad".equals(keyOpenAi)) {
			log.warn("[ChatGptService] OpenAI API key is not configured (openai.api.key). Calls will fail.");
		}
	}

	// ---------- helpers ----------

	@Override
	public String generateResponse(String prompt) {
		log.info("[ChatGptService] Generating response, model={}, promptPreview={}",
				openAiModel, preview(prompt, 160));

		try {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			headers.setBearerAuth(keyOpenAi);

			Map<String, Object> body = Map.of(
					"model", openAiModel,
					"messages", List.of(
							Map.of("role", "system", "content", SystemPrompt.getPrompt()),
							Map.of("role", "user", "content", prompt)
					)
					// Ajoute si besoin: "temperature", "top_p", "max_tokens", etc.
			);

			HttpEntity<Map<String, Object>> request = new HttpEntity<>(body, headers);
			ResponseEntity<Map> response = restTemplate.postForEntity(urlOpenAi, request, Map.class);

			if (response.getStatusCode() != HttpStatus.OK) {
				String err = String.format("OpenAI HTTP %s", response.getStatusCodeValue());
				log.error("[ChatGptService] Bad status from OpenAI: {}", err);
				return err;
			}

			Map<?, ?> root = response.getBody();
			if (root == null) {
				log.error("[ChatGptService] Empty body from OpenAI");
				return "Réponse vide de l'IA.";
			}

			Object choicesObj = root.get("choices");
			if (!(choicesObj instanceof List<?> choices) || choices.isEmpty()) {
				log.warn("[ChatGptService] No choices from OpenAI");
				return "Aucune réponse générée.";
			}

			Object choice = choices.get(0);
			if (!(choice instanceof Map<?, ?> choiceMap)) {
				log.warn("[ChatGptService] Malformed choice");
				return "Réponse IA malformée.";
			}

			Object msgObj = choiceMap.get("message");
			if (!(msgObj instanceof Map<?, ?> msgMap)) {
				log.warn("[ChatGptService] Missing message in choice");
				return "Réponse IA malformée.";
			}

			Object content = msgMap.get("content");
			String result = (content == null) ? "" : content.toString();

			log.info("[ChatGptService] OK contentPreview={}", preview(result, 200));
			return result;

		} catch (Exception e) {
			log.error("❌ Failed to call ChatGPT: {}", e.getMessage(), e);
			return e.getMessage();
		}
	}

	@Override
	public String getCategory(String type, String userId, String categoryName, String tenant) {
		log.info("[ChatGptService] getCategory type={} userId={} categoryName='{}' tenant={}",
				safe(type), safe(userId), safe(categoryName), safe(tenant));

		// 1) Cherche une catégorie existante
		Category category = null;
		try {
			category = categoryRepository.findByNameAndCreatedById(categoryName, userId)
					.stream()
					.findFirst()
					.orElse(null);
		} catch (Exception e) {
			log.error("[ChatGptService] categoryRepository.findByNameAndCreatedById failed: {}", e.getMessage(), e);
		}

		if (category != null) {
			log.info("[ChatGptService] Category found id={} name='{}'", category.getId(), category.getName());
			return category.getLocalId();
		}

		// 2) Sinon, crée une nouvelle catégorie
		try {
			CategoryRequest categoryRequest = CategoryRequest.builder()
					.name(categoryName)
					.code(categoryName)
					.typeEntry(type)
					.isPublic(false)
					.description(categoryName)
					.build();

			MetaRequest metaRequest = MetaRequest.builder()
					.userId(userId)
					.tenantId(tenant)
					.build();

			categoryRequest.setLocalId(UUID.randomUUID().toString());

			log.info("LocalId generated: {}", categoryRequest.getLocalId());

			String id = categoryCreateApplicationService.createCategory(categoryRequest, metaRequest).getLocalId();
			log.info("[ChatGptService] Category created id={} name='{}'", id, categoryName);
			return id;
		} catch (Exception e) {
			log.error("[ChatGptService] Failed to create category '{}': {}", categoryName, e.getMessage(), e);
			// Fallback vers un libellé "Autre" si ton domaine tolère l'ID d’une catégorie générique
			// Sinon, remonte null/exception pour que l’appelant mette FAIL.
			return null;
		}
	}

	/**
	 * Simple wrapper to re-expose the buffered body after logging.
	 */
	private static class BufferingClientHttpResponse implements ClientHttpResponse {
		private final ClientHttpResponse delegate;
		private final byte[] body;

		BufferingClientHttpResponse(ClientHttpResponse delegate, byte[] body) {
			this.delegate = delegate;
			this.body = body;
		}

		@Override
		public HttpStatusCode getStatusCode() {
			try {
				return delegate.getStatusCode();
			} catch (Exception e) {
				return HttpStatus.INTERNAL_SERVER_ERROR;
			}
		}

		@Override
		public int getRawStatusCode() {
			try {
				return delegate.getRawStatusCode();
			} catch (Exception e) {
				return 500;
			}
		}

		@Override
		public String getStatusText() {
			try {
				return delegate.getStatusText();
			} catch (Exception e) {
				return "ERROR";
			}
		}

		@Override
		public void close() {
			delegate.close();
		}

		@Override
		public InputStream getBody() {
			return new ByteArrayInputStream(body);
		}

		@Override
		public HttpHeaders getHeaders() {
			return delegate.getHeaders();
		}
	}
}
