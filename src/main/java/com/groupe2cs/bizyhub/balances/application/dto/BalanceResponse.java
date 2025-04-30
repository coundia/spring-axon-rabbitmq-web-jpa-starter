package com.groupe2cs.bizyhub.balances.application.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serializable;

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

}
