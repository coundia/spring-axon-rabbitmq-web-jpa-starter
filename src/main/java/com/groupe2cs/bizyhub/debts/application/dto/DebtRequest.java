package com.groupe2cs.bizyhub.debts.application.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(name = "DebtRequest", description = "Request payload for Debt operations")
public class DebtRequest implements Serializable {

	@Schema(description = "", example = "044db40c-9d2e-4ff1-b2b4-5f72c4ed263a")
	private String remoteId;
	@Schema(description = "", example = "eec3e8e4-c553-4258-bc1d-789eeff32788")
	private String localId;
	@Schema(description = "", example = "90d48d62-45fe-45f2-af2f-4700cee4e48a")
	private String code;
	@Schema(description = "", example = "61b0b650-0504-4eb4-9d65-8779a2dabcfa")
	private String notes;
	@Schema(description = "", example = "8183.46")
	private Double balance;
	@Schema(description = "", example = "6057.53")
	private Double balanceDebt;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant dueDate;
	@Schema(description = "", example = "f59bf16c-1e8c-4b16-a534-5b1a3ffbe307")
	private String statuses;
	@Schema(description = "", example = "d5e7acc2-7574-4ecb-be1e-3bb2990c5cb3")
	private String account;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant syncAt;
	@Schema(description = "", example = "2305cb80-33db-4650-b0ba-b9ae5cb5c48d")
	private String customer;
	@Schema(description = "", example = "false")
	private Boolean isActive;

}
