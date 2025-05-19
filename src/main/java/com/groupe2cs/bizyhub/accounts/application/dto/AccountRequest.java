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

	@Schema(description = "", example = "a4ab813c-6036-4e6d-b26b-5780ef12e808")
	private String name;

	@Schema(description = "", example = "c57a6f6e-9360-4633-b41a-98867962549b")
	private String currency;

	@Schema(description = "", example = "877.5")
	private Double currentBalance;

	@Schema(description = "", example = "7996.87")
	private Double previousBalance;

	@Schema(description = "", example = "7ae5417b-db03-4bef-ad40-22dc810330c2")
	private String details;

	@Schema(description = "", example = "false")
	private Boolean isActive;

	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant updatedAt;

	@Schema(description = "", example = "ac1ecd10-d389-4204-b931-ffaa2e1fac1f")
	private String reference;


}
