package com.groupe2cs.bizyhub.balances.application.dto;

import com.groupe2cs.bizyhub.balances.domain.valueObject.*;
import com.groupe2cs.bizyhub.balances.infrastructure.entity.*;
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
@Schema(name = "BalanceResponse", description = "Response payload for Balance")
public class BalanceResponse implements Serializable {

	@Schema(description = "", example = "")
	private String id;
	@Schema(description = "", example = "")
	private String name;
	@Schema(description = "", example = "")
	private String currency;
	@Schema(description = "", example = "")
	private Double currentBalance;
	@Schema(description = "", example = "")
	private Double previousBalance;
	@Schema(description = "", example = "")
	private java.time.Instant lastUpdated;
	@Schema(description = "", example = "")
	private Boolean isDefault;
	@Schema(description = "", example = "")
	private Integer ordre;
	@Schema(description = "", example = "")
	private Boolean isArchived;
	@Schema(description = "", example = "")
	private Boolean isAllowDebit;
	@Schema(description = "", example = "")
	private Boolean isAllowCredit;
	@Schema(description = "", example = "")
	private Boolean isExcluTotal;
	@Schema(description = "", example = "")
	private Boolean activateNotification;
	@Schema(description = "", example = "")
	private java.time.Instant syncedAt;
	@Schema(description = "", example = "")
	private java.time.Instant updatedAt;
	@Schema(description = "", example = "")
	private String reference;

}
