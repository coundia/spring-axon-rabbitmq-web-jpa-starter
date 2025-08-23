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

	@Schema(description = "", example = "5465a95b-0fcf-4b68-b59b-8734194f47e2")
	private String code;
	@Schema(description = "", example = "828b98c4-c08c-4a1e-97fd-924cc920d8a6")
	private String name;
	@Schema(description = "", example = "53a72101-98ef-486c-9945-a33e64158baf")
	private String status;
	@Schema(description = "", example = "00d68732-2ea3-4fbc-b8aa-c7745f2e556c")
	private String currency;
	@Schema(description = "", example = "c730cfae-d8dc-495e-9c9c-5fa5f74fb2f5")
	private String typeAccount;
	@Schema(description = "", example = "6765.99")
	private Double balance;
	@Schema(description = "", example = "8743.53")
	private Double balancePrev;
	@Schema(description = "", example = "9093.92")
	private Double balanceBlocked;
	@Schema(description = "", example = "5963.51")
	private Double balanceInit;
	@Schema(description = "", example = "1545.78")
	private Double balanceGoal;
	@Schema(description = "", example = "8991.32")
	private Double balanceLimit;
	@Schema(description = "", example = "251a580a-fd90-440c-8190-c7ec1b5f7d43")
	private String description;
	@Schema(description = "", example = "true")
	private Boolean isActive;
	@Schema(description = "", example = "true")
	private Boolean isDefault;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant syncAt;

}
