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

	@Schema(description = "", example = "b93a0b1e-586d-4d86-8528-b87147dc804e")
	private String name;

	@Schema(description = "", example = "8611.6")
	private Double amount;

	@Schema(description = "", example = "88af38bc-0ea9-4a6f-a547-8b3368462aa6")
	private String details;

	@Schema(description = "", example = "true")
	private Boolean isActive;

	@Schema(description = "", example = "fda5f333-364e-4306-ba8c-36ad426d79b4")
	private String account;

	@Schema(description = "", example = "bc220816-67ad-4ece-b4eb-91e8a8490f06")
	private String category;

	@Schema(description = "", example = "97e220f9-15e7-47d2-868e-275eca475d90")
	private String typeTransactionRaw;

	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant dateTransaction;

	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant updatedAt;

	@Schema(description = "", example = "867f960d-7d6c-4b8c-b799-b052f18eee2c")
	private String reference;


}
