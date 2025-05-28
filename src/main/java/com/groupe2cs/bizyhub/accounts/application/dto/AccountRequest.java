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

	@Schema(description = "", example = "ebae571f-f9c9-41ba-9f5a-6f0f52d825b3")
	private String name;
	@Schema(description = "", example = "acf6f57d-a605-46a1-bbea-29b532110bb9")
	private String currency;
	@Schema(description = "", example = "4167.75")
	private Double currentBalance;
	@Schema(description = "", example = "9788.18")
	private Double previousBalance;
	@Schema(description = "", example = "3d108bf8-75ce-4f3c-80d0-2842918221d4")
	private String details;
	@Schema(description = "", example = "true")
	private Boolean isActive;

}
