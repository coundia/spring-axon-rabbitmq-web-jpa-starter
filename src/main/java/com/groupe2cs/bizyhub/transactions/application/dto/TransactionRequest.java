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

	@Schema(description = "", example = "7b66b214-8b2b-4804-b12c-413c848c5653")
	private String name;

	@Schema(description = "", example = "2605.26")
	private Double amount;

	@Schema(description = "", example = "90c2aa9a-a911-4b53-aa0a-7b8aacd528ae")
	private String details;

	@Schema(description = "", example = "false")
	private Boolean isActive;

	@Schema(description = "", example = "058a4543-6936-4c8c-bf23-318c11456fe9")
	private String account;

	@Schema(description = "", example = "6a70b1d3-898a-4886-b411-1de270464370")
	private String category;

	@Schema(description = "", example = "e2ff4d27-2b2e-4708-b543-73758d6ae46f")
	private String typeTransactionRaw;

	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant dateTransaction;

	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant updatedAt;

	@Schema(description = "", example = "87400c48-f48a-4343-9472-5155aeabd1dc")
	private String reference;


}
