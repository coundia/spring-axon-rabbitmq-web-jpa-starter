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

	@Schema(description = "", example = "5b7e0825-8892-4bfc-8adc-52776ec66f9f")
	private String name;

	@Schema(description = "", example = "9c7c5c7d-992f-40fd-9671-c8cb78a761d4")
	private String currency;

	@Schema(description = "", example = "1355.58")
	private Double currentBalance;

	@Schema(description = "", example = "3210.99")
	private Double previousBalance;

	@Schema(description = "", example = "4119e4fb-8d12-438e-95f8-268a0f308b44")
	private String details;

	@Schema(description = "", example = "false")
	private Boolean isActive;

	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant updatedAt;

	@Schema(description = "", example = "3173d7c2-5b88-4983-9ca2-5f0077564230")
	private String reference;


}
