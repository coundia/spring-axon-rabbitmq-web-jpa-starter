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

	@Schema(description = "", example = "dbb82359-5fee-4d30-a369-f685ac88658c")
	private String remoteId;
	@Schema(description = "", example = "5c793a24-0062-4fd7-b12e-2197c994e407")
	private String localId;
	@Schema(description = "", example = "7181b196-f7f9-4a63-a3cd-996e18f9b6a4")
	private String code;
	@Schema(description = "", example = "3c415d2f-bcdd-4cd7-ab35-edf54364601a")
	private String notes;
	@Schema(description = "", example = "3885.17")
	private Double balance;
	@Schema(description = "", example = "6987.84")
	private Double balanceDebt;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant dueDate;
	@Schema(description = "", example = "97f70099-c737-4216-90ed-96182dcbcc4a")
	private String statuses;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant syncAt;
	@Schema(description = "", example = "109eda66-dff5-4dcc-96a2-7db2fb05b4df")
	private String customer;
	@Schema(description = "", example = "false")
	private Boolean isActive;

}
