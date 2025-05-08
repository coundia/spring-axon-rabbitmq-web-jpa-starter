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

	@Schema(description = "", example = "23b9f684-4b78-46d7-bb1d-df2f954a4c84")
	private String name;

	@Schema(description = "", example = "1eba9932-8eac-4539-b39a-04d544c5c5bf")
	private String currency;

	@Schema(description = "", example = "4739.73")
	private Double currentBalance;

	@Schema(description = "", example = "6242.68")
	private Double previousBalance;

	@Schema(description = "", example = "cd2af48a-dd73-45e0-b2b9-2f78bcda402d")
	private String details;

	@Schema(description = "", example = "false")
	private Boolean isActive;

	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant updatedAt;

	@Schema(description = "", example = "6855694b-4493-441a-a514-1dd52a871b6e")
	private String reference;


}
