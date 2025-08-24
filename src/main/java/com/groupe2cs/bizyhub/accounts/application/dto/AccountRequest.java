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

	@Schema(description = "", example = "467c9bcc-be0c-499e-960b-f4d86f7c67aa")
	private String code;
	@Schema(description = "", example = "baae104b-de15-48df-b72e-338e766f0315")
	private String name;
	@Schema(description = "", example = "1f398bd0-7bb9-44a4-b653-a4b31994ec9a")
	private String status;
	@Schema(description = "", example = "c1a3dda7-f81f-48b7-b5b3-b0c1fee18ce5")
	private String currency;
	@Schema(description = "", example = "e36fedf4-b552-4e9e-b52e-0d5ddd6c1f6c")
	private String typeAccount;
	@Schema(description = "", example = "7098.31")
	private Double balance;
	@Schema(description = "", example = "9088.0")
	private Double balancePrev;
	@Schema(description = "", example = "4693.08")
	private Double balanceBlocked;
	@Schema(description = "", example = "7302.81")
	private Double balanceInit;
	@Schema(description = "", example = "1458.52")
	private Double balanceGoal;
	@Schema(description = "", example = "1251.98")
	private Double balanceLimit;
	@Schema(description = "", example = "7b4dabfe-6af5-4a5e-a258-cf742c14218a")
	private String description;
	@Schema(description = "", example = "false")
	private Boolean isActive;
	@Schema(description = "", example = "false")
	private Boolean isDefault;
	@Schema(description = "", example = "a058e910-fff7-4213-80de-128d62389d1c")
	private String remoteId;
	@Schema(description = "", example = "fe0bb0d4-2a3c-4260-b0a1-69372c6814b7")
	private String localId;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant syncAt;

}
