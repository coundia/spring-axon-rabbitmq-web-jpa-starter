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

	@Schema(description = "", example = "920fc3ed-7dab-4aeb-af8d-b17316c26f33")
	private String name;
	@Schema(description = "", example = "cb4ebbd7-5736-4f11-8eba-f6123a3a6435")
	private String currency;
	@Schema(description = "", example = "2284.65")
	private Double currentBalance;
	@Schema(description = "", example = "4001.25")
	private Double previousBalance;
	@Schema(description = "", example = "2675b314-1098-4c89-8b2c-408a8e6bdc1f")
	private String details;
	@Schema(description = "", example = "false")
	private Boolean isActive;

}
