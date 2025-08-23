package com.groupe2cs.bizyhub.shared.infrastructure.ia;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.groupe2cs.bizyhub.categories.application.dto.CategoryRequest;
import com.groupe2cs.bizyhub.categories.application.usecase.CategoryCreateApplicationService;
import com.groupe2cs.bizyhub.categories.infrastructure.entity.Category;
import com.groupe2cs.bizyhub.categories.infrastructure.repository.CategoryRepository;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.transactions.application.dto.TransactionDeltaDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class FakeIAService implements IAService {

	private final CategoryRepository categoryRepository;
	private final ObjectMapper objectMapper = new ObjectMapper();

	private final CategoryCreateApplicationService categoryCreateApplicationService;


	@Override
	public String getCategory(String type, String userId, String categoryName, String tenant) {
		log.info("getCategory");

		Category category = categoryRepository.findByNameAndCreatedById(categoryName, userId)
				.stream()
				.findFirst()
				.orElse(null);

		if (category != null) {
			log.info("Category found: {}", category);
			return category.getId();
		}

		log.info("Category not found, creating a new one");

		CategoryRequest categoryRequest = CategoryRequest
				.builder()
				.name(categoryName)
				//.typeCategoryRaw(type)
				//	.updatedAt(Instant.now())
				//.isActive(true)
			//	.details("")
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


	public String generateResponse(String prompt) {
		log.info("[FakeIAService] Generating response for prompt: {}", prompt);


		try {


			TransactionDeltaDto transactionDeltaDto = TransactionDeltaDto
					.builder()
					.id(UUID.randomUUID().toString())
					.type("CREATE")
					.name("Transaction " + UUID.randomUUID())
					.details("Description " + UUID.randomUUID())
					.amount(new Random().nextDouble() * 1000)
					.isActive(true)
					.account(UUID.randomUUID().toString())
					.category(getCategory(
							"IN",
							"06b14751-26f6-47d8-a56a-157aa0605301",
							"CATEGORY" + UUID.randomUUID(),
							"fab97fa4-c796-4921-b1d2-db8d671d3a4e"
					))
					.typeTransactionRaw("IN")
					//.reference(UUID.randomUUID().toString())
					.build();


			return objectMapper.writeValueAsString(Map.of("deltas", List.of(transactionDeltaDto)));
		} catch (JsonProcessingException e) {
			log.error("❌ Failed to serialize fake transaction: {}", e.getMessage(), e);
			return "{\"error\": \"serialization_failed\"}";
		}
	}
}
