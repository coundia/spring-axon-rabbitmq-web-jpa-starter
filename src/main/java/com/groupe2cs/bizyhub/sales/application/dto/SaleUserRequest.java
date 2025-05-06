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
@Schema(name = "SaleUserRequest", description = "Request payload for SaleUser operations")
public class SaleUserRequest implements Serializable {

	@Schema(description = "", example = "16ad90c8-34e0-44db-ba99-fbb0827f0d3e")
	private String sales;

	@Schema(description = "", example = "2119c788-8adf-437a-b534-aac0a854241d")
	private String users;

	@Schema(description = "", example = "0fa8af27-5da8-4740-b54f-ea5ed934a86b")
	private String details;

	@Schema(description = "", example = "false")
	private Boolean isActive;

	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant updatedAt;

	@Schema(description = "", example = "31798cf0-9753-4272-a241-43e6c01537c5")
	private String reference;


}
