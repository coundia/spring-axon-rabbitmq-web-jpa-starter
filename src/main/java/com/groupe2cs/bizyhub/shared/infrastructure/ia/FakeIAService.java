package com.groupe2cs.bizyhub.shared.infrastructure.ia;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.groupe2cs.bizyhub.transactions.application.dto.TransactionDeltaDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class FakeIAService implements IAService {

	private final ObjectMapper objectMapper = new ObjectMapper();

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
				.category(UUID.randomUUID().toString())
				.typeTransactionRaw(UUID.randomUUID().toString())
				.reference(UUID.randomUUID().toString())
				.build();


			return objectMapper.writeValueAsString(Map.of("deltas", List.of(transactionDeltaDto)));
		} catch (JsonProcessingException e) {
			log.error("❌ Failed to serialize fake transaction: {}", e.getMessage(), e);
			return "{\"error\": \"serialization_failed\"}";
		}
	}
}
