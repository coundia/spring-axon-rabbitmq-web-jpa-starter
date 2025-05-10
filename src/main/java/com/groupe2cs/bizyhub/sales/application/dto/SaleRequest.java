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

	@Schema(description = "", example = "da4cf03e-8ef6-4922-b40e-2d837ce36f50")
	private String name;

	@Schema(description = "", example = "5747.29")
	private Double amount;

	@Schema(description = "", example = "0c097d16-c8d5-4751-b718-83eca19da528")
	private String details;

	@Schema(description = "", example = "true")
	private Boolean isActive;

	@Schema(description = "", example = "e18e8752-e293-4a10-b502-f3512ff4ab7c")
	private String account;

	@Schema(description = "", example = "95752ae8-d7fb-41d9-b61c-841df50ebdc4")
	private String category;

	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant updatedAt;

	@Schema(description = "", example = "6f7599c1-206c-446f-9b9a-a4a66649d515")
	private String reference;


}
