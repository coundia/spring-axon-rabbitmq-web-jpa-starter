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

	@Schema(description = "", example = "49a20197-36d2-4a75-8c84-0f2ba56ef8c0")
	private String remoteId;
	@Schema(description = "", example = "a2d6f383-e43c-4fd8-a8e1-74a8e6f4449f")
	private String code;
	@Schema(description = "", example = "18ee1407-ba63-457c-b4ce-fc27da03fc6f")
	private String notes;
	@Schema(description = "", example = "95.82")
	private Double balance;
	@Schema(description = "", example = "1992.44")
	private Double balanceDebt;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant dueDate;
	@Schema(description = "", example = "db850ed1-87ea-47af-9898-7c51d6904e47")
	private String statuses;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant syncAt;
	@Schema(description = "", example = "287417d7-48dc-467d-ab1d-60dd5f3f3804")
	private String customer;
	@Schema(description = "", example = "true")
	private Boolean isActive;

}
