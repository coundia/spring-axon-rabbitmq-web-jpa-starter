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

	@Schema(description = "", example = "143a2ffa-22ec-48c3-a415-967241a409b9")
	private String name;

	@Schema(description = "", example = "9740ef14-364d-4639-8117-7e265df6b753")
	private String currency;

	@Schema(description = "", example = "3016.75")
	private Double currentBalance;

	@Schema(description = "", example = "484.18")
	private Double previousBalance;

	@Schema(description = "", example = "4b1ffd3f-0c97-4e62-b485-d47891b90862")
	private String details;

	@Schema(description = "", example = "true")
	private Boolean isActive;

	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant updatedAt;

	@Schema(description = "", example = "a9705159-c154-48f9-aeb7-d961310de72e")
	private String reference;


}
