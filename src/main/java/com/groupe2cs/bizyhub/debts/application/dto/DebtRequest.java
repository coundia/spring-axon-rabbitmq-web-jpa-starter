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

	@Schema(description = "", example = "5d74dc0e-a301-4bb5-9bde-a50291d21309")
	private String remoteId;
	@Schema(description = "", example = "833c28e1-404d-4bf8-94fa-262257b5c14b")
	private String localId;
	@Schema(description = "", example = "05e40ff9-227c-42de-b634-15b4fdca9b40")
	private String code;
	@Schema(description = "", example = "4762b24a-3ca0-4d97-b2d0-9069b3e6be58")
	private String notes;
	@Schema(description = "", example = "4103.49")
	private Double balance;
	@Schema(description = "", example = "2449.58")
	private Double balanceDebt;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant dueDate;
	@Schema(description = "", example = "a054e273-5335-4235-8db9-c5c9b924a797")
	private String statuses;
	@Schema(description = "", example = "210aba98-15b8-4fc4-b3a4-5e41a7713dc0")
	private String account;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant syncAt;
	@Schema(description = "", example = "612a0a6f-4278-4482-8f3f-9c32efcf7c05")
	private String customer;
	@Schema(description = "", example = "true")
	private Boolean isActive;

}
