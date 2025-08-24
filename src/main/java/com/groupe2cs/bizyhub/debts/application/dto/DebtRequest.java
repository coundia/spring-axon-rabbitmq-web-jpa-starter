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

	@Schema(description = "", example = "3decfcf6-d76e-4fbb-b906-b669d529048c")
	private String remoteId;
	@Schema(description = "", example = "f7e0aad2-1bfd-4047-99e2-7e53c4e68ffb")
	private String code;
	@Schema(description = "", example = "181479d9-da68-48e7-8697-29ee6d8a5287")
	private String notes;
	@Schema(description = "", example = "2684.22")
	private Double balance;
	@Schema(description = "", example = "5006.6")
	private Double balanceDebt;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant dueDate;
	@Schema(description = "", example = "60aa08eb-eeeb-4c3d-a525-9c6fdf6dc3ca")
	private String statuses;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant syncAt;
	@Schema(description = "", example = "9f3f38f6-7c65-4fa4-aa3e-86b2e1ff352f")
	private String customer;
	@Schema(description = "", example = "false")
	private Boolean isActive;

}
