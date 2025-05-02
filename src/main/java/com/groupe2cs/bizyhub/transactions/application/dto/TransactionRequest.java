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

	@Schema(description = "", example = "4132.07")
	private Double amount;

	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant dateOperation;

	@Schema(description = "", example = "6dc9227b-8ac2-44f9-8776-a6287127b9b3")
	private String description;

	@Schema(description = "", example = "66f3c05d-c6ac-46a5-93bd-ee3389c23354")
	private String reference;

	@Schema(description = "", example = "false")
	private Boolean isRecurring;

	@Schema(description = "", example = "true")
	private Boolean isExcluToRapport;

	@Schema(description = "", example = "28a912b8-69fb-474e-93e9-08289c52412a")
	private String status;

	@Schema(description = "", example = "90a98e4c-db7d-4f29-83ce-597e7d043402")
	private String balance;

	@Schema(description = "", example = "85e8dbc1-b533-46fc-b0e6-2bdb23f98c7d")
	private String category;

	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant updatedAt;

	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant createdAt;


}
