package com.groupe2cs.bizyhub.balances.application.dto;

import com.groupe2cs.bizyhub.balances.domain.valueObject.*;
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
@Schema(name = "BalanceRequest", description = "Request payload for Balance operations")
public class BalanceRequest implements Serializable {

	@Schema(description = "", example = "ea492936-36d6-4a2b-8ea2-9e3a991ddd4d")
	private String name;

	@Schema(description = "", example = "463391bd-8f4c-403a-8dcc-d8cd0e966010")
	private String currency;

	@Schema(description = "", example = "1679.06")
	private Double currentBalance;

	@Schema(description = "", example = "4833.73")
	private Double previousBalance;

	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant lastUpdated;

	@Schema(description = "", example = "false")
	private Boolean isDefault;

	@Schema(description = "", example = "89")
	private Integer ordre;

	@Schema(description = "", example = "true")
	private Boolean isArchived;

	@Schema(description = "", example = "true")
	private Boolean isAllowDebit;

	@Schema(description = "", example = "true")
	private Boolean isAllowCredit;

	@Schema(description = "", example = "true")
	private Boolean isExcluTotal;

	@Schema(description = "", example = "true")
	private Boolean activateNotification;

	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant syncedAt;

	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant updatedAt;

	@Schema(description = "", example = "fc6cac81-5d6a-4cb5-b8d3-ef3d72aec08f")
	private String reference;


}
