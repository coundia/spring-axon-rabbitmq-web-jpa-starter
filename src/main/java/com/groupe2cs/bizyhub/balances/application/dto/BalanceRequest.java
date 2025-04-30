package com.groupe2cs.bizyhub.balances.application.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(name = "BalanceRequest", description = "Request payload for Balance operations")
public class BalanceRequest implements Serializable {

	@Schema(description = "", example = "a93d3f36-02a4-49bc-a0d0-99eae0a78ac3")
	private String name;

	@Schema(description = "", example = "292b2787-4872-452d-8e11-a32c0a708fb6")
	private String currency;

	@Schema(description = "", example = "6401.05")
	private Double currentBalance;

	@Schema(description = "", example = "9022.42")
	private Double previousBalance;

	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant lastUpdated;

	@Schema(description = "", example = "false")
	private Boolean isDefault;

	@Schema(description = "", example = "84")
	private Integer ordre;

	@Schema(description = "", example = "true")
	private Boolean isArchived;

	@Schema(description = "", example = "true")
	private Boolean isAllowDebit;

	@Schema(description = "", example = "true")
	private Boolean isAllowCredit;

	@Schema(description = "", example = "false")
	private Boolean isExcluTotal;

	@Schema(description = "", example = "false")
	private Boolean activateNotification;

	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant syncedAt;


}
