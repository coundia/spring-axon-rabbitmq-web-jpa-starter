package com.groupe2cs.bizyhub.sales.application.dto;

import com.groupe2cs.bizyhub.sales.domain.valueObject.*;
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
@Schema(name = "SaleRequest", description = "Request payload for Sale operations")
public class SaleRequest implements Serializable {

	@Schema(description = "", example = "bb82f0f1-58ce-4b8b-8a13-6531bb2de453")
	private String name;

	@Schema(description = "", example = "8192.13")
	private Double amount;

	@Schema(description = "", example = "619950d6-f505-4c47-b016-9fd375828a01")
	private String details;

	@Schema(description = "", example = "false")
	private Boolean isActive;

	@Schema(description = "", example = "25d8ad0a-af00-499f-8911-ad5555426df6")
	private String account;

	@Schema(description = "", example = "e2b1f056-5288-4e54-bdbf-a50d4013ed22")
	private String category;

	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant updatedAt;

	@Schema(description = "", example = "67283417-a2de-456b-a239-8c9e0fe0bc3a")
	private String reference;


}
