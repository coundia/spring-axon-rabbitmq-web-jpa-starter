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

	@Schema(description = "", example = "b9e4b1a8-1543-47dd-91c2-e63e6175ad77")
	private String code;
	@Schema(description = "", example = "49919099-9ac8-417c-99cb-f688bb1627fa")
	private String name;
	@Schema(description = "", example = "6ff7d323-a1ec-41d2-bbc0-3f8820fc6280")
	private String status;
	@Schema(description = "", example = "1abe0f86-e996-4abe-8b3d-6cc6b659d16b")
	private String currency;
	@Schema(description = "", example = "68a2438a-9426-4599-b655-ebee162b3359")
	private String typeAccount;
	@Schema(description = "", example = "7949.79")
	private Double balance;
	@Schema(description = "", example = "341.0")
	private Double balancePrev;
	@Schema(description = "", example = "4037.31")
	private Double balanceBlocked;
	@Schema(description = "", example = "6551.55")
	private Double balanceInit;
	@Schema(description = "", example = "5448.84")
	private Double balanceGoal;
	@Schema(description = "", example = "8829.15")
	private Double balanceLimit;
	@Schema(description = "", example = "7bcf9634-5151-4955-8a7b-2905d3f745a1")
	private String description;
	@Schema(description = "", example = "true")
	private Boolean isActive;
	@Schema(description = "", example = "false")
	private Boolean isDefault;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant syncAt;

}
