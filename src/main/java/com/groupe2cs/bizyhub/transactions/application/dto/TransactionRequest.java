package com.groupe2cs.bizyhub.transactions.application.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(name = "TransactionRequest", description = "Request payload for Transaction operations")
public class TransactionRequest implements Serializable {

	@Schema(description = "", example = "5229.73")
	private Double amount;

	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant dateOperation;

	@Schema(description = "", example = "14dcf583-557e-4d82-93f2-7d9a1959cdc7")
	private String description;

	@Schema(description = "", example = "2503b2b7-5ea7-49c0-918d-0207cf5fd90b")
	private String reference;

	@Schema(description = "", example = "false")
	private Boolean isRecurring;

	@Schema(description = "", example = "false")
	private Boolean isExcluToRapport;

	@Schema(description = "", example = "d9ea6de0-f355-476b-9baf-e039f20d16f2")
	private String status;

	@Schema(description = "", example = "f314c9dc-7265-4d27-9529-b4b53b94b01a")
	private String balance;

	@Schema(description = "", example = "86784fbe-fdfa-4694-8da8-760ae2e9440b")
	private String category;

	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant updatedAt;

	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant createdAt;


}
