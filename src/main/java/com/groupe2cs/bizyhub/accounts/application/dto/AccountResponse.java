package com.groupe2cs.bizyhub.accounts.application.dto;

import com.groupe2cs.bizyhub.accounts.domain.valueObject.*;
import com.groupe2cs.bizyhub.accounts.infrastructure.entity.*;
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
@Schema(name = "AccountResponse", description = "Response payload for Account")
public class AccountResponse implements Serializable {

	@Schema(description = "", example = "")
	private String id;
	@Schema(description = "", example = "")
	private String code;
	@Schema(description = "", example = "")
	private String name;
	@Schema(description = "", example = "")
	private String status;
	@Schema(description = "", example = "")
	private String currency;
	@Schema(description = "", example = "")
	private String typeAccount;
	@Schema(description = "", example = "")
	private Double balance;
	@Schema(description = "", example = "")
	private Double balancePrev;
	@Schema(description = "", example = "")
	private Double balanceBlocked;
	@Schema(description = "", example = "")
	private Double balanceInit;
	@Schema(description = "", example = "")
	private Double balanceGoal;
	@Schema(description = "", example = "")
	private Double balanceLimit;
	@Schema(description = "", example = "")
	private String description;
	@Schema(description = "", example = "")
	private Boolean isActive;
	@Schema(description = "", example = "")
	private Boolean isDefault;
	@Schema(description = "", example = "")
	private java.time.Instant syncAt;
	@Schema(description = "", example = "")
	private String createdBy;
	@Schema(description = "", example = "")
	private String tenant;

}
