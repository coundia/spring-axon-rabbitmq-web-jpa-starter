package com.groupe2cs.bizyhub.accounts.application.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(name = "AccountRequest", description = "Request payload for Account operations")
public class AccountRequest implements Serializable {

	@Schema(description = "", example = "447937bc-1ac6-43b2-9734-4986ebf7e032")
	private String code;
	@Schema(description = "", example = "eefb75e9-4510-4df9-9a24-ce5e1c2dee59")
	private String name;
	@Schema(description = "", example = "f6b2c7d8-3ad9-40bc-b063-c269703c5d72")
	private String status;
	@Schema(description = "", example = "851ed790-e9ee-487b-b7df-e0c28cf6fdaf")
	private String currency;
	@Schema(description = "", example = "c48cc3bc-ace7-4cc5-98c2-9d279ea41140")
	private String typeAccount;
	@Schema(description = "", example = "5183.95")
	private Double balance;
	@Schema(description = "", example = "6631.15")
	private Double balancePrev;
	@Schema(description = "", example = "744.36")
	private Double balanceBlocked;
	@Schema(description = "", example = "9577.99")
	private Double balanceInit;
	@Schema(description = "", example = "2181.68")
	private Double balanceGoal;
	@Schema(description = "", example = "8910.82")
	private Double balanceLimit;
	@Schema(description = "", example = "df55fe94-9dab-4019-9683-eb3938f145ce")
	private String description;
	@Schema(description = "", example = "true")
	private Boolean isActive;
	@Schema(description = "", example = "false")
	private Boolean isDefault;
	@Schema(description = "", example = "0472f75f-0b59-413a-90ef-290c6cfaceae")
	private String remoteId;
	@Schema(description = "", example = "d2e08815-eaab-4ce3-aa92-57258a05b19c")
	private String localId;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant syncAt;

}
