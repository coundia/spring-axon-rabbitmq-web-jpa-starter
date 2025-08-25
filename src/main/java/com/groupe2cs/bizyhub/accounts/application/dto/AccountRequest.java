package com.groupe2cs.bizyhub.accounts.application.dto;

import com.groupe2cs.bizyhub.accounts.domain.valueObject.*;
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
@Schema(name = "AccountRequest", description = "Request payload for Account operations")
public class AccountRequest implements Serializable {

	@Schema(description = "", example = "e95bb9a4-8ba6-48f4-9387-599417f6c635")
	private String code;
	@Schema(description = "", example = "b4f808a6-3473-4ac2-9ba9-efcc98dfa979")
	private String name;
	@Schema(description = "", example = "ab047cba-c94c-4e02-8efd-1a655406124c")
	private String status;
	@Schema(description = "", example = "de2cacf7-1ba7-42b6-91e8-407b1164c6f0")
	private String currency;
	@Schema(description = "", example = "6b0f5ad4-fde7-4d86-9ffb-6135d4f99757")
	private String typeAccount;
	@Schema(description = "", example = "764.38")
	private Double balance;
	@Schema(description = "", example = "2199.79")
	private Double balancePrev;
	@Schema(description = "", example = "761.51")
	private Double balanceBlocked;
	@Schema(description = "", example = "7717.07")
	private Double balanceInit;
	@Schema(description = "", example = "4036.03")
	private Double balanceGoal;
	@Schema(description = "", example = "2197.84")
	private Double balanceLimit;
	@Schema(description = "", example = "793f6fe3-167c-44f5-9f32-314881bb42b6")
	private String description;
	@Schema(description = "", example = "true")
	private Boolean isActive;
	@Schema(description = "", example = "false")
	private Boolean isDefault;
	@Schema(description = "", example = "4593fc7a-6b34-4cde-b5b4-16646ca2b0b0")
	private String remoteId;
	@Schema(description = "", example = "df0a5346-f6bd-4d28-af3b-dbde43b66196")
	private String localId;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant syncAt;

}
