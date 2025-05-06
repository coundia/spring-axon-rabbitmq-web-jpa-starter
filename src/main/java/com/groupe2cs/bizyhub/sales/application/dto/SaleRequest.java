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

	@Schema(description = "", example = "7e2e621b-a88a-421f-a80b-e7843b19675d")
	private String name;

	@Schema(description = "", example = "9708.0")
	private Double amount;

	@Schema(description = "", example = "d26b5b60-6319-461b-aa33-f8ff0d567a4e")
	private String details;

	@Schema(description = "", example = "false")
	private Boolean isActive;

	@Schema(description = "", example = "216d3bf7-5ea7-4f8d-84ca-a05d9a24f169")
	private String product;

	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant updatedAt;

	@Schema(description = "", example = "e96e0557-2408-4a73-8902-277429954351")
	private String reference;


}
