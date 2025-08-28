package com.groupe2cs.bizyhub.debts.application.dto;

import com.groupe2cs.bizyhub.debts.domain.valueObject.*;
import com.groupe2cs.bizyhub.debts.infrastructure.entity.*;
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
@Schema(name = "DebtResponse", description = "Response payload for Debt")
public class DebtResponse implements Serializable {

	@Schema(description = "", example = "")
	private String id;
	@Schema(description = "", example = "")
	private String remoteId;
	@Schema(description = "", example = "")
	private String localId;
	@Schema(description = "", example = "")
	private String code;
	@Schema(description = "", example = "")
	private String notes;
	@Schema(description = "", example = "")
	private Double balance;
	@Schema(description = "", example = "")
	private Double balanceDebt;
	@Schema(description = "", example = "")
	private java.time.Instant dueDate;
	@Schema(description = "", example = "")
	private String statuses;
	@Schema(description = "", example = "")
	private String account;
	@Schema(description = "", example = "")
	private java.time.Instant syncAt;
	@Schema(description = "", example = "")
	private String customer;
	@Schema(description = "", example = "")
	private Boolean isActive;
	@Schema(description = "", example = "")
	private String createdBy;
	@Schema(description = "", example = "")
	private String tenant;

}
