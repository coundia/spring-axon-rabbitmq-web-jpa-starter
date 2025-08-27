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

	@Schema(description = "", example = "5543e321-2c84-4ed4-ad73-f14723703d40")
	private String code;
	@Schema(description = "", example = "ec626d56-b34f-47be-b843-1a09638d5f1f")
	private String name;
	@Schema(description = "", example = "cf36097d-fa58-4a3b-9d2a-9b327518b31e")
	private String status;
	@Schema(description = "", example = "c692a548-4c49-4d99-afbe-c4f85802a875")
	private String currency;
	@Schema(description = "", example = "68f95a5f-748e-4c0d-9f7d-e48928d2da77")
	private String typeAccount;
	@Schema(description = "", example = "2954.4")
	private Double balance;
	@Schema(description = "", example = "2613.12")
	private Double balancePrev;
	@Schema(description = "", example = "1617.65")
	private Double balanceBlocked;
	@Schema(description = "", example = "2063.52")
	private Double balanceInit;
	@Schema(description = "", example = "8020.99")
	private Double balanceGoal;
	@Schema(description = "", example = "2719.84")
	private Double balanceLimit;
	@Schema(description = "", example = "5a2ba6c6-fc04-486a-ab29-4a242f1b2404")
	private String description;
	@Schema(description = "", example = "false")
	private Boolean isActive;
	@Schema(description = "", example = "true")
	private Boolean isDefault;
	@Schema(description = "", example = "d6d5f127-56c0-4f54-97de-504e5fc209c8")
	private String remoteId;
	@Schema(description = "", example = "83d50fa2-a69a-409b-a290-d699a7d0c56e")
	private String localId;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant syncAt;

}
