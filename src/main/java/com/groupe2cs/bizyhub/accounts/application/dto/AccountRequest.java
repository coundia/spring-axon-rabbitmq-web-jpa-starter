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

	@Schema(description = "", example = "89686635-19fd-42dc-9245-3244373ac895")
	private String code;
	@Schema(description = "", example = "dfc08df3-a585-4eb5-89a6-2fe95e01cbe5")
	private String name;
	@Schema(description = "", example = "ff76ff40-1713-40de-a5ef-5bf5cf19007a")
	private String status;
	@Schema(description = "", example = "ccb8838d-db2c-4842-a9af-278d273dcf51")
	private String currency;
	@Schema(description = "", example = "a236c4ba-ad8e-4106-8fa4-a2b3bc02cf25")
	private String typeAccount;
	@Schema(description = "", example = "1344.37")
	private Double balance;
	@Schema(description = "", example = "5492.56")
	private Double balancePrev;
	@Schema(description = "", example = "2204.77")
	private Double balanceBlocked;
	@Schema(description = "", example = "813.17")
	private Double balanceInit;
	@Schema(description = "", example = "5918.11")
	private Double balanceGoal;
	@Schema(description = "", example = "8497.65")
	private Double balanceLimit;
	@Schema(description = "", example = "2fb83d48-ca3a-4bff-ae7a-dc87b526d726")
	private String description;
	@Schema(description = "", example = "true")
	private Boolean isActive;
	@Schema(description = "", example = "false")
	private Boolean isDefault;
	@Schema(description = "", example = "45758f34-c6fc-44cc-bcb3-c39d23ae17db")
	private String remoteId;
	@Schema(description = "", example = "eedd39db-4c35-42d5-8f2c-67b11fbcbff7")
	private String localId;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant syncAt;

}
