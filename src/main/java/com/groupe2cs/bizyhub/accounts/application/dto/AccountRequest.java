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

	@Schema(description = "", example = "659bf0f3-087d-4b75-b1ba-42e25f84ddcb")
	private String name;

	@Schema(description = "", example = "0b4db9c0-0c60-4bb8-add7-942cde596dd3")
	private String currency;

	@Schema(description = "", example = "9395.16")
	private Double currentBalance;

	@Schema(description = "", example = "6538.37")
	private Double previousBalance;

	@Schema(description = "", example = "d965ebb6-d324-41fa-92c4-3ad31f967673")
	private String details;

	@Schema(description = "", example = "true")
	private Boolean isActive;

	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant updatedAt;

	@Schema(description = "", example = "367f96c8-c501-4c7b-afd7-5ea6b2cb2b0b")
	private String reference;


}
