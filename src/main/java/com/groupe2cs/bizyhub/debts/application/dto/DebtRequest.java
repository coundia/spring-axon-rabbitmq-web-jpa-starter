package com.groupe2cs.bizyhub.debts.application.dto;

import com.groupe2cs.bizyhub.debts.domain.valueObject.*;
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
@Schema(name = "DebtRequest", description = "Request payload for Debt operations")
public class DebtRequest implements Serializable {

	@Schema(description = "", example = "b9483f46-c812-4ce7-a17d-93010214435b")
	private String remoteId;
	@Schema(description = "", example = "431c9ff6-ca2c-403b-9d5d-fd0bf98baeff")
	private String localId;
	@Schema(description = "", example = "0e6875c0-7a3f-4e60-bfc1-0cd338e63877")
	private String code;
	@Schema(description = "", example = "c4f78dfa-14d0-444a-b9b7-652ffdb8b34b")
	private String notes;
	@Schema(description = "", example = "4687.69")
	private Double balance;
	@Schema(description = "", example = "1157.39")
	private Double balanceDebt;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant dueDate;
	@Schema(description = "", example = "1774abb1-f08e-44b0-9098-1da5a0a85be2")
	private String statuses;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant syncAt;
	@Schema(description = "", example = "323bcb55-6d1c-4bc8-8386-cc3b23b9b2af")
	private String customer;
	@Schema(description = "", example = "true")
	private Boolean isActive;

}
