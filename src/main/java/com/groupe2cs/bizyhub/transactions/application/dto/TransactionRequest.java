package com.groupe2cs.bizyhub.transactions.application.dto;

import com.groupe2cs.bizyhub.transactions.domain.valueObject.*;
import java.util.UUID;
import java.io.Serializable;
import java.util.concurrent.ThreadLocalRandom;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Builder;
import io.swagger.v3.oas.annotations.media.Schema;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(name = "TransactionRequest", description = "Request payload for Transaction operations")
public class TransactionRequest implements Serializable {

	@Schema(description = "", example = "a3745c08-4fc8-46c6-bdca-ac63206ced57")
	private String name;

	@Schema(description = "", example = "1957.87")
	private Double amount;

	@Schema(description = "", example = "95f25305-024e-4381-8853-0dd68155e977")
	private String details;

	@Schema(description = "", example = "true")
	private Boolean isActive;

	@Schema(description = "", example = "a191ed7d-f132-4cab-94ce-337d9e6aabb9")
	private String account;

	@Schema(description = "", example = "85ca103d-189a-4394-9326-1905a6d74e72")
	private String category;

	@Schema(description = "", example = "2a490b6c-9521-4165-9090-6fa5b4f6f358")
	private String typeTransactionRaw;

	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant dateTransaction;

	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant updatedAt;

	@Schema(description = "", example = "a644b222-d8b9-4d9f-864f-864fd335a7ff")
	private String reference;


}
